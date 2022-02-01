package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.y;

public class SimpleImageView
  extends ImageView
{
  public MMHandler handler;
  public String imagePath;
  public int nxO;
  public int nxP;
  public String url;
  
  public SimpleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55930);
    this.url = null;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(55928);
        byte[] arrayOfByte = (byte[])paramAnonymousMessage.obj;
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          Log.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(55928);
          return;
        }
        paramAnonymousMessage = BitmapUtil.decodeByteArray(arrayOfByte);
        String str = SimpleImageView.a(SimpleImageView.this) + g.getMessageDigest(SimpleImageView.b(SimpleImageView.this).getBytes());
        Log.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[] { str });
        y.f(str, arrayOfByte, arrayOfByte.length);
        if ((paramAnonymousMessage != null) && (SimpleImageView.c(SimpleImageView.this) > 0) && (SimpleImageView.d(SimpleImageView.this) > 0)) {
          paramAnonymousMessage = BitmapUtil.extractThumbNail(paramAnonymousMessage, SimpleImageView.d(SimpleImageView.this), SimpleImageView.c(SimpleImageView.this), true, false);
        }
        for (;;)
        {
          SimpleImageView.this.setImageBitmap(paramAnonymousMessage);
          AppMethodBeat.o(55928);
          return;
        }
      }
    };
    AppMethodBeat.o(55930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView
 * JD-Core Version:    0.7.0.1
 */