package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;

public class SimpleImageView
  extends ImageView
{
  public int gNU;
  public int gNV;
  public ao handler;
  public String imagePath;
  public String url;
  
  public SimpleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55930);
    this.url = null;
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(55928);
        byte[] arrayOfByte = (byte[])paramAnonymousMessage.obj;
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          ac.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(55928);
          return;
        }
        paramAnonymousMessage = f.ck(arrayOfByte);
        String str = SimpleImageView.a(SimpleImageView.this) + g.getMessageDigest(SimpleImageView.b(SimpleImageView.this).getBytes());
        ac.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[] { str });
        i.f(str, arrayOfByte, arrayOfByte.length);
        if ((paramAnonymousMessage != null) && (SimpleImageView.c(SimpleImageView.this) > 0) && (SimpleImageView.d(SimpleImageView.this) > 0)) {
          paramAnonymousMessage = f.a(paramAnonymousMessage, SimpleImageView.d(SimpleImageView.this), SimpleImageView.c(SimpleImageView.this), true, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView
 * JD-Core Version:    0.7.0.1
 */