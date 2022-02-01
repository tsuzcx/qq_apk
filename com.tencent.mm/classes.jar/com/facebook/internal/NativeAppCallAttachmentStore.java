package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
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
    AppMethodBeat.i(17872);
    TAG = NativeAppCallAttachmentStore.class.getName();
    AppMethodBeat.o(17872);
  }
  
  public static void addAttachments(Collection<Attachment> paramCollection)
  {
    AppMethodBeat.i(17864);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(17864);
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
          break label194;
        }
        localObject2 = (Attachment)paramCollection.next();
        if (((Attachment)localObject2).shouldCreateFile)
        {
          localFile = getAttachmentFile(((Attachment)localObject2).callId, ((Attachment)localObject2).attachmentName, true);
          ((List)localObject1).add(localFile);
          if (((Attachment)localObject2).bitmap == null) {
            break;
          }
          processAttachmentBitmap(((Attachment)localObject2).bitmap, localFile);
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
        if (localException.originalUri != null) {
          processAttachmentFile(localException.originalUri, localException.isContentUri, localFile);
        }
      }
      label194:
      AppMethodBeat.o(17864);
      return;
      paramCollection = new FacebookException(paramCollection);
      AppMethodBeat.o(17864);
      throw paramCollection;
    }
  }
  
  public static void cleanupAllAttachments()
  {
    AppMethodBeat.i(17871);
    Utility.deleteDirectory(getAttachmentsDirectory());
    AppMethodBeat.o(17871);
  }
  
  public static void cleanupAttachmentsForCall(UUID paramUUID)
  {
    AppMethodBeat.i(17865);
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, false);
    if (paramUUID != null) {
      Utility.deleteDirectory(paramUUID);
    }
    AppMethodBeat.o(17865);
  }
  
  public static Attachment createAttachment(UUID paramUUID, Bitmap paramBitmap)
  {
    AppMethodBeat.i(17860);
    Validate.notNull(paramUUID, "callId");
    Validate.notNull(paramBitmap, "attachmentBitmap");
    paramUUID = new Attachment(paramUUID, paramBitmap, null, null);
    AppMethodBeat.o(17860);
    return paramUUID;
  }
  
  public static Attachment createAttachment(UUID paramUUID, Uri paramUri)
  {
    AppMethodBeat.i(17861);
    Validate.notNull(paramUUID, "callId");
    Validate.notNull(paramUri, "attachmentUri");
    paramUUID = new Attachment(paramUUID, null, paramUri, null);
    AppMethodBeat.o(17861);
    return paramUUID;
  }
  
  static File ensureAttachmentsDirectoryExists()
  {
    AppMethodBeat.i(17868);
    File localFile = getAttachmentsDirectory();
    localFile.mkdirs();
    AppMethodBeat.o(17868);
    return localFile;
  }
  
  static File getAttachmentFile(UUID paramUUID, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(17870);
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, paramBoolean);
    if (paramUUID == null)
    {
      AppMethodBeat.o(17870);
      return null;
    }
    try
    {
      paramUUID = new File(paramUUID, URLEncoder.encode(paramString, "UTF-8"));
      AppMethodBeat.o(17870);
      return paramUUID;
    }
    catch (UnsupportedEncodingException paramUUID)
    {
      AppMethodBeat.o(17870);
    }
    return null;
  }
  
  static File getAttachmentsDirectory()
  {
    try
    {
      AppMethodBeat.i(17867);
      if (attachmentsDirectory == null) {
        attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
      }
      File localFile = attachmentsDirectory;
      AppMethodBeat.o(17867);
      return localFile;
    }
    finally {}
  }
  
  static File getAttachmentsDirectoryForCall(UUID paramUUID, boolean paramBoolean)
  {
    AppMethodBeat.i(17869);
    if (attachmentsDirectory == null)
    {
      AppMethodBeat.o(17869);
      return null;
    }
    paramUUID = new File(attachmentsDirectory, paramUUID.toString());
    if ((paramBoolean) && (!paramUUID.exists())) {
      paramUUID.mkdirs();
    }
    AppMethodBeat.o(17869);
    return paramUUID;
  }
  
  public static File openAttachment(UUID paramUUID, String paramString)
  {
    AppMethodBeat.i(17866);
    if ((Utility.isNullOrEmpty(paramString)) || (paramUUID == null))
    {
      paramUUID = new FileNotFoundException();
      AppMethodBeat.o(17866);
      throw paramUUID;
    }
    try
    {
      paramUUID = getAttachmentFile(paramUUID, paramString, false);
      AppMethodBeat.o(17866);
      return paramUUID;
    }
    catch (IOException paramUUID)
    {
      paramUUID = new FileNotFoundException();
      AppMethodBeat.o(17866);
      throw paramUUID;
    }
  }
  
  private static void processAttachmentBitmap(Bitmap paramBitmap, File paramFile)
  {
    AppMethodBeat.i(17862);
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramFile);
      return;
    }
    finally
    {
      Utility.closeQuietly(paramFile);
      AppMethodBeat.o(17862);
    }
  }
  
  private static void processAttachmentFile(Uri paramUri, boolean paramBoolean, File paramFile)
  {
    AppMethodBeat.i(17863);
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
        AppMethodBeat.o(17863);
      }
      paramUri = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri);
    }
  }
  
  public static final class Attachment
  {
    private final String attachmentName;
    private final String attachmentUrl;
    private Bitmap bitmap;
    private final UUID callId;
    private boolean isContentUri;
    private Uri originalUri;
    private boolean shouldCreateFile;
    
    private Attachment(UUID paramUUID, Bitmap paramBitmap, Uri paramUri)
    {
      AppMethodBeat.i(17859);
      this.callId = paramUUID;
      this.bitmap = paramBitmap;
      this.originalUri = paramUri;
      if (paramUri != null)
      {
        paramBitmap = paramUri.getScheme();
        if ("content".equalsIgnoreCase(paramBitmap))
        {
          this.isContentUri = true;
          if ((paramUri.getAuthority() != null) && (!paramUri.getAuthority().startsWith("media")))
          {
            this.shouldCreateFile = bool;
            label76:
            if (this.shouldCreateFile) {
              break label205;
            }
            paramBitmap = null;
            label85:
            this.attachmentName = paramBitmap;
            if (this.shouldCreateFile) {
              break label215;
            }
          }
        }
      }
      label205:
      label215:
      for (paramUUID = this.originalUri.toString();; paramUUID = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), paramUUID, this.attachmentName))
      {
        this.attachmentUrl = paramUUID;
        AppMethodBeat.o(17859);
        return;
        bool = false;
        break;
        if ("file".equalsIgnoreCase(paramUri.getScheme()))
        {
          this.shouldCreateFile = true;
          break label76;
        }
        if (Utility.isWebUri(paramUri)) {
          break label76;
        }
        paramUUID = new FacebookException("Unsupported scheme for media Uri : ".concat(String.valueOf(paramBitmap)));
        AppMethodBeat.o(17859);
        throw paramUUID;
        if (paramBitmap != null)
        {
          this.shouldCreateFile = true;
          break label76;
        }
        paramUUID = new FacebookException("Cannot share media without a bitmap or Uri set");
        AppMethodBeat.o(17859);
        throw paramUUID;
        paramBitmap = UUID.randomUUID().toString();
        break label85;
      }
    }
    
    public final String getAttachmentUrl()
    {
      return this.attachmentUrl;
    }
    
    public final Uri getOriginalUri()
    {
      return this.originalUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.NativeAppCallAttachmentStore
 * JD-Core Version:    0.7.0.1
 */