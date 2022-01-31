package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class NativeAppCallAttachmentStore
{
  static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
  private static final String TAG;
  private static File attachmentsDirectory;
  
  static
  {
    AppMethodBeat.i(72436);
    TAG = NativeAppCallAttachmentStore.class.getName();
    AppMethodBeat.o(72436);
  }
  
  public static void addAttachments(Collection<NativeAppCallAttachmentStore.Attachment> paramCollection)
  {
    AppMethodBeat.i(72428);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(72428);
      return;
    }
    if (attachmentsDirectory == null) {
      cleanupAllAttachments();
    }
    ensureAttachmentsDirectoryExists();
    Object localObject1 = new ArrayList();
    try
    {
      paramCollection = paramCollection.iterator();
      for (;;)
      {
        if (!paramCollection.hasNext()) {
          break label192;
        }
        localObject2 = (NativeAppCallAttachmentStore.Attachment)paramCollection.next();
        if (NativeAppCallAttachmentStore.Attachment.access$100((NativeAppCallAttachmentStore.Attachment)localObject2))
        {
          localFile = getAttachmentFile(NativeAppCallAttachmentStore.Attachment.access$200((NativeAppCallAttachmentStore.Attachment)localObject2), NativeAppCallAttachmentStore.Attachment.access$300((NativeAppCallAttachmentStore.Attachment)localObject2), true);
          ((List)localObject1).add(localFile);
          if (NativeAppCallAttachmentStore.Attachment.access$400((NativeAppCallAttachmentStore.Attachment)localObject2) == null) {
            break;
          }
          processAttachmentBitmap(NativeAppCallAttachmentStore.Attachment.access$400((NativeAppCallAttachmentStore.Attachment)localObject2), localFile);
        }
      }
    }
    catch (IOException paramCollection)
    {
      for (;;)
      {
        Object localObject2;
        File localFile;
        new StringBuilder("Got unexpected exception:").append(paramCollection);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (File)((Iterator)localObject1).next();
          try
          {
            ((File)localObject2).delete();
          }
          catch (Exception localException) {}
        }
        if (NativeAppCallAttachmentStore.Attachment.access$500(localException) != null) {
          processAttachmentFile(NativeAppCallAttachmentStore.Attachment.access$500(localException), NativeAppCallAttachmentStore.Attachment.access$600(localException), localFile);
        }
      }
      label192:
      AppMethodBeat.o(72428);
      return;
      paramCollection = new FacebookException(paramCollection);
      AppMethodBeat.o(72428);
      throw paramCollection;
    }
  }
  
  public static void cleanupAllAttachments()
  {
    AppMethodBeat.i(72435);
    Utility.deleteDirectory(getAttachmentsDirectory());
    AppMethodBeat.o(72435);
  }
  
  public static void cleanupAttachmentsForCall(UUID paramUUID)
  {
    AppMethodBeat.i(72429);
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, false);
    if (paramUUID != null) {
      Utility.deleteDirectory(paramUUID);
    }
    AppMethodBeat.o(72429);
  }
  
  public static NativeAppCallAttachmentStore.Attachment createAttachment(UUID paramUUID, Bitmap paramBitmap)
  {
    AppMethodBeat.i(72424);
    Validate.notNull(paramUUID, "callId");
    Validate.notNull(paramBitmap, "attachmentBitmap");
    paramUUID = new NativeAppCallAttachmentStore.Attachment(paramUUID, paramBitmap, null, null);
    AppMethodBeat.o(72424);
    return paramUUID;
  }
  
  public static NativeAppCallAttachmentStore.Attachment createAttachment(UUID paramUUID, Uri paramUri)
  {
    AppMethodBeat.i(72425);
    Validate.notNull(paramUUID, "callId");
    Validate.notNull(paramUri, "attachmentUri");
    paramUUID = new NativeAppCallAttachmentStore.Attachment(paramUUID, null, paramUri, null);
    AppMethodBeat.o(72425);
    return paramUUID;
  }
  
  static File ensureAttachmentsDirectoryExists()
  {
    AppMethodBeat.i(72432);
    File localFile = getAttachmentsDirectory();
    localFile.mkdirs();
    AppMethodBeat.o(72432);
    return localFile;
  }
  
  static File getAttachmentFile(UUID paramUUID, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(72434);
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, paramBoolean);
    if (paramUUID == null)
    {
      AppMethodBeat.o(72434);
      return null;
    }
    try
    {
      paramUUID = new File(paramUUID, URLEncoder.encode(paramString, "UTF-8"));
      AppMethodBeat.o(72434);
      return paramUUID;
    }
    catch (UnsupportedEncodingException paramUUID)
    {
      AppMethodBeat.o(72434);
    }
    return null;
  }
  
  static File getAttachmentsDirectory()
  {
    try
    {
      AppMethodBeat.i(72431);
      if (attachmentsDirectory == null) {
        attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
      }
      File localFile = attachmentsDirectory;
      AppMethodBeat.o(72431);
      return localFile;
    }
    finally {}
  }
  
  static File getAttachmentsDirectoryForCall(UUID paramUUID, boolean paramBoolean)
  {
    AppMethodBeat.i(72433);
    if (attachmentsDirectory == null)
    {
      AppMethodBeat.o(72433);
      return null;
    }
    paramUUID = new File(attachmentsDirectory, paramUUID.toString());
    if ((paramBoolean) && (!paramUUID.exists())) {
      paramUUID.mkdirs();
    }
    AppMethodBeat.o(72433);
    return paramUUID;
  }
  
  public static File openAttachment(UUID paramUUID, String paramString)
  {
    AppMethodBeat.i(72430);
    if ((Utility.isNullOrEmpty(paramString)) || (paramUUID == null))
    {
      paramUUID = new FileNotFoundException();
      AppMethodBeat.o(72430);
      throw paramUUID;
    }
    try
    {
      paramUUID = getAttachmentFile(paramUUID, paramString, false);
      AppMethodBeat.o(72430);
      return paramUUID;
    }
    catch (IOException paramUUID)
    {
      paramUUID = new FileNotFoundException();
      AppMethodBeat.o(72430);
      throw paramUUID;
    }
  }
  
  private static void processAttachmentBitmap(Bitmap paramBitmap, File paramFile)
  {
    AppMethodBeat.i(72426);
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramFile);
      return;
    }
    finally
    {
      Utility.closeQuietly(paramFile);
      AppMethodBeat.o(72426);
    }
  }
  
  private static void processAttachmentFile(Uri paramUri, boolean paramBoolean, File paramFile)
  {
    AppMethodBeat.i(72427);
    paramFile = new FileOutputStream(paramFile);
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramUri = new FileInputStream(paramUri.getPath());
        Utility.copyAndCloseInputStream(paramUri, paramFile);
        return;
      }
      finally
      {
        Utility.closeQuietly(paramFile);
        AppMethodBeat.o(72427);
      }
      paramUri = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.NativeAppCallAttachmentStore
 * JD-Core Version:    0.7.0.1
 */