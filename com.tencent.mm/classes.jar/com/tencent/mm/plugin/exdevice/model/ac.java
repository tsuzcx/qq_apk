package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.al;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean hjP;
  private View qdo;
  private TextView qdp;
  private TextView qdq;
  private TextView qdr;
  private TextView qds;
  private View qdt;
  boolean qdu;
  Dialog qdv;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    ag.aFZ();
    Object localObject = f.aFy();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = v.zf((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(g.decodeFile(paramString2, null));
      paramString2 = new su();
      paramString2.dHn.dtZ = localWXMediaMessage;
      paramString2.dHn.appId = "wx7fa037cc7dfabad5";
      paramString2.dHn.appName = paramContext.getString(2131758621);
      paramString2.dHn.toUser = paramString1;
      paramString2.dHn.dua = 2;
      if (!bt.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.dHn.dHq = null;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.sdk.b.a.IbL.l(paramString2);
      if (!bt.isNullOrNil(paramString3))
      {
        paramContext = new sx();
        paramContext.dHy.dHz = paramString1;
        paramContext.dHy.content = paramString3;
        paramContext.dHy.type = w.Ar(paramString1);
        paramContext.dHy.flags = 0;
        com.tencent.mm.sdk.b.a.IbL.l(paramContext);
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.dHn.dHo = ((String)localObject);
      paramString2.dHn.dHp = str;
    }
  }
  
  public static final String eD(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = q.B(new e(paramContext.getCacheDir(), "sport_share_bitmap.jpg").fOK());
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  final String U(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = al.aG(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ShapeDrawable.ShaderFactory()
      {
        public final Shader resize(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(23444);
          float f = paramAnonymousInt2;
          paramAnonymousInt1 = paramBitmap[0];
          Object localObject = Shader.TileMode.REPEAT;
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, paramAnonymousInt1 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject);
          AppMethodBeat.o(23444);
          return localObject;
        }
      };
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.qdt.setBackgroundDrawable(localPaintDrawable);
      this.qdp.setTextColor(paramBitmap[1]);
      this.qdq.setTextColor(paramBitmap[1]);
      this.qdr.setTextColor(paramBitmap[1]);
      this.qds.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.qdo.draw((Canvas)localObject);
      localObject = new e(eD(this.context));
      if (((e)localObject).exists()) {
        ((e)localObject).delete();
      }
      try
      {
        g.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, q.B(((e)localObject).fOK()), true);
        label174:
        paramBitmap = q.B(((e)localObject).fOK());
        AppMethodBeat.o(23447);
        return paramBitmap;
        paramBitmap = new int[2];
        Bitmap tmp195_194 = paramBitmap;
        tmp195_194[0] = -1;
        Bitmap tmp199_195 = tmp195_194;
        tmp199_195[1] = -16777216;
        tmp199_195;
      }
      catch (IOException paramBitmap)
      {
        break label174;
      }
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(23446);
    if (this.qdu)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.qdu = true;
    this.hjP = false;
    if ((this.qdv == null) && (!bt.isNullOrNil(paramString3)))
    {
      paramContext.getString(2131755906);
      this.qdv = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131758606), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ac.this.hjP = true;
        }
      });
      this.qdv.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cc.a.ip(paramContext)) {
      this.width = com.tencent.mm.cc.a.ip(paramContext);
    }
    this.qdo = LayoutInflater.from(paramContext).inflate(2131493894, null);
    this.qdp = ((TextView)this.qdo.findViewById(2131299586));
    this.qdq = ((TextView)this.qdo.findViewById(2131299584));
    this.qdr = ((TextView)this.qdo.findViewById(2131299596));
    this.qds = ((TextView)this.qdo.findViewById(2131299595));
    this.qdt = this.qdo.findViewById(2131297207);
    this.qdp.setText(paramString1);
    this.qdr.setText(paramString2);
    a.b.a((ImageView)this.qdo.findViewById(2131296997), u.aAm(), 0.5F, false);
    paramContext = (ImageView)this.qdo.findViewById(2131297204);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.qdo.setLayoutParams(paramString1);
    this.qdo.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.qdo.layout(0, 0, this.width, this.width);
    if (!bt.isNullOrNil(paramString3))
    {
      ad.clw().a(paramString3, paramContext, new com.tencent.mm.aw.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ac.this.hjP)
          {
            ac.this.qdu = false;
            AppMethodBeat.o(23443);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ac.this.qdv.isShowing()) {
                ac.this.qdv.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ac.this.U(paramAnonymousb.bitmap);
          parama.acx(paramAnonymousString);
          ac.this.qdu = false;
          AppMethodBeat.o(23443);
        }
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(2131100204);
    parama.acx(U(null));
    this.qdu = false;
    AppMethodBeat.o(23446);
  }
  
  public static abstract interface a
  {
    public abstract void acx(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */