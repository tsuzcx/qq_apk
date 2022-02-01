package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider
  extends ContentProvider
{
  private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
  private static final String INVALID_FILE_NAME = "..";
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(17014);
    TAG = FacebookContentProvider.class.getName();
    AppMethodBeat.o(17014);
  }
  
  public static String getAttachmentUrl(String paramString1, UUID paramUUID, String paramString2)
  {
    AppMethodBeat.i(17011);
    paramString1 = String.format("%s%s/%s/%s", new Object[] { "content://com.facebook.app.FacebookContentProvider", paramString1, paramUUID.toString(), paramString2 });
    AppMethodBeat.o(17011);
    return paramString1;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(17012);
    paramUri = parseCallIdAndAttachmentName(paramUri);
    if (paramUri == null)
    {
      paramUri = new FileNotFoundException();
      AppMethodBeat.o(17012);
      throw paramUri;
    }
    try
    {
      paramUri = NativeAppCallAttachmentStore.openAttachment((UUID)paramUri.first, (String)paramUri.second);
      if (paramUri == null)
      {
        paramUri = new FileNotFoundException();
        AppMethodBeat.o(17012);
        throw paramUri;
      }
    }
    catch (FileNotFoundException paramUri)
    {
      new StringBuilder("Got unexpected exception:").append(paramUri);
      AppMethodBeat.o(17012);
      throw paramUri;
    }
    paramUri = ParcelFileDescriptor.open(paramUri, 268435456);
    AppMethodBeat.o(17012);
    return paramUri;
  }
  
  Pair<UUID, String> parseCallIdAndAttachmentName(Uri paramUri)
  {
    AppMethodBeat.i(17013);
    Object localObject;
    try
    {
      localObject = paramUri.getPath().substring(1).split("/");
      paramUri = localObject[0];
      localObject = localObject[1];
      if (("..".contentEquals(paramUri)) || ("..".contentEquals((CharSequence)localObject)))
      {
        paramUri = new Exception();
        AppMethodBeat.o(17013);
        throw paramUri;
      }
    }
    catch (Exception paramUri)
    {
      AppMethodBeat.o(17013);
      return null;
    }
    paramUri = new Pair(UUID.fromString(paramUri), localObject);
    AppMethodBeat.o(17013);
    return paramUri;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.FacebookContentProvider
 * JD-Core Version:    0.7.0.1
 */