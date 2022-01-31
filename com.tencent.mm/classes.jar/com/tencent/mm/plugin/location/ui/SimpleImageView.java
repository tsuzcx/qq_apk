package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public class SimpleImageView
  extends ImageView
{
  public int eIB;
  public int eIC;
  public ah handler = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      byte[] arrayOfByte = (byte[])paramAnonymousMessage.obj;
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        y.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
        return;
      }
      paramAnonymousMessage = c.bu(arrayOfByte);
      String str = SimpleImageView.a(SimpleImageView.this) + g.o(SimpleImageView.b(SimpleImageView.this).getBytes());
      y.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[] { str });
      e.b(str, arrayOfByte, arrayOfByte.length);
      if ((paramAnonymousMessage != null) && (SimpleImageView.c(SimpleImageView.this) > 0) && (SimpleImageView.d(SimpleImageView.this) > 0)) {
        paramAnonymousMessage = c.a(paramAnonymousMessage, SimpleImageView.d(SimpleImageView.this), SimpleImageView.c(SimpleImageView.this), true, false);
      }
      for (;;)
      {
        SimpleImageView.this.setImageBitmap(paramAnonymousMessage);
        return;
      }
    }
  };
  public String imagePath;
  public String url = null;
  
  public SimpleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView
 * JD-Core Version:    0.7.0.1
 */