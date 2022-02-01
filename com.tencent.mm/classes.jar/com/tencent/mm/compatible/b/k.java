package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

public final class k
  extends MediaPlayer
{
  public k()
  {
    AppMethodBeat.i(155617);
    g.qN(hashCode());
    AppMethodBeat.o(155617);
  }
  
  public static k b(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(155618);
    try
    {
      k localk = new k();
      localk.setDataSource(paramContext, paramUri);
      localk.prepare();
      AppMethodBeat.o(155618);
      return localk;
    }
    catch (IOException paramContext)
    {
      Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      AppMethodBeat.o(155618);
      return null;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(155623);
    super.release();
    g.qO(hashCode());
    AppMethodBeat.o(155623);
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(155620);
    if (d.rb(26))
    {
      setDataSource(paramContext, paramUri, null, null);
      AppMethodBeat.o(155620);
      return;
    }
    setDataSource(paramContext, paramUri, null);
    AppMethodBeat.o(155620);
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    AppMethodBeat.i(155621);
    if (d.rb(26))
    {
      setDataSource(paramContext, paramUri, paramMap, null);
      AppMethodBeat.o(155621);
      return;
    }
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file")) || (str.equals("wcf")) || (str.equals("assets")))
    {
      paramUri = y.a(paramUri, null, "r");
      try
      {
        setDataSource(paramUri.getFileDescriptor());
        if (paramUri != null)
        {
          paramUri.close();
          AppMethodBeat.o(155621);
          return;
        }
      }
      finally
      {
        if (paramUri != null) {}
        try
        {
          paramUri.close();
          AppMethodBeat.o(155621);
          throw paramContext;
        }
        finally
        {
          paramContext.addSuppressed(paramUri);
        }
        AppMethodBeat.o(155621);
        return;
      }
    }
    super.setDataSource(paramContext, paramUri, paramMap);
    AppMethodBeat.o(155621);
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap, List<HttpCookie> paramList)
  {
    AppMethodBeat.i(155622);
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file")) || (str.equals("wcf")) || (str.equals("assets")))
    {
      paramUri = y.a(paramUri, null, "r");
      try
      {
        setDataSource(paramUri.getFileDescriptor());
        if (paramUri != null)
        {
          paramUri.close();
          AppMethodBeat.o(155622);
          return;
        }
      }
      finally
      {
        if (paramUri != null) {}
        try
        {
          paramUri.close();
          AppMethodBeat.o(155622);
          throw paramContext;
        }
        finally
        {
          paramContext.addSuppressed(paramUri);
        }
        AppMethodBeat.o(155622);
        return;
      }
    }
    super.setDataSource(paramContext, paramUri, paramMap, paramList);
    AppMethodBeat.o(155622);
  }
  
  /* Error */
  public final void setDataSource(String paramString)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 98
    //   8: invokestatic 136	com/tencent/mm/vfs/y:qk	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_3
    //   14: invokevirtual 110	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   17: invokevirtual 113	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   20: aload_3
    //   21: ifnull +7 -> 28
    //   24: aload_3
    //   25: invokevirtual 116	android/os/ParcelFileDescriptor:close	()V
    //   28: ldc 132
    //   30: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: astore_2
    //   35: aload_3
    //   36: ifnull +7 -> 43
    //   39: aload_3
    //   40: invokevirtual 116	android/os/ParcelFileDescriptor:close	()V
    //   43: ldc 132
    //   45: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_2
    //   49: athrow
    //   50: astore_2
    //   51: ldc 49
    //   53: new 138	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 140
    //   59: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 148
    //   68: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 151	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 160	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   89: ldc 132
    //   91: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_3
    //   96: aload_2
    //   97: aload_3
    //   98: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   101: goto -58 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	k
    //   0	104	1	paramString	String
    //   34	15	2	localObject	Object
    //   50	47	2	localFileNotFoundException	java.io.FileNotFoundException
    //   11	29	3	localParcelFileDescriptor	ParcelFileDescriptor
    //   95	3	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	20	34	finally
    //   5	12	50	java/io/FileNotFoundException
    //   24	28	50	java/io/FileNotFoundException
    //   43	50	50	java/io/FileNotFoundException
    //   96	101	50	java/io/FileNotFoundException
    //   39	43	95	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.b.k
 * JD-Core Version:    0.7.0.1
 */