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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.List;

public final class ad
{
  private Context context;
  boolean kUn;
  private View vgA;
  boolean vgB;
  Dialog vgC;
  private View vgv;
  private TextView vgw;
  private TextView vgx;
  private TextView vgy;
  private TextView vgz;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    af.bjv();
    Object localObject = f.biW();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = aa.PJ((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(BitmapUtil.decodeFile(paramString2, null));
      paramString2 = new uw();
      paramString2.fUc.fvl = localWXMediaMessage;
      paramString2.fUc.appId = "wx7fa037cc7dfabad5";
      paramString2.fUc.appName = paramContext.getString(R.l.exdevice_wechat_sport);
      paramString2.fUc.toUser = paramString1;
      paramString2.fUc.fFO = 2;
      if (!Util.isNullOrNil((String)localObject)) {
        break label254;
      }
      paramString2.fUc.fUf = null;
    }
    for (;;)
    {
      boolean bool = EventCenter.instance.publish(paramString2);
      if (!Util.isNullOrNil(paramString3))
      {
        paramContext = new uz();
        paramContext.fUn.fcD = paramString1;
        paramContext.fUn.content = paramString3;
        paramContext.fUn.type = ab.QZ(paramString1);
        paramContext.fUn.flags = 0;
        EventCenter.instance.publish(paramContext);
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label254:
      paramString2.fUc.fUd = ((String)localObject);
      paramString2.fUc.fUe = str;
    }
  }
  
  public static final String ff(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = new q(paramContext.getCacheDir(), "sport_share_bitmap.jpg").bOF();
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  final String Y(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = ar.aJ(paramBitmap);
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
      this.vgA.setBackgroundDrawable(localPaintDrawable);
      this.vgw.setTextColor(paramBitmap[1]);
      this.vgx.setTextColor(paramBitmap[1]);
      this.vgy.setTextColor(paramBitmap[1]);
      this.vgz.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.vgv.draw((Canvas)localObject);
      localObject = new q(ff(this.context));
      if (((q)localObject).ifE()) {
        ((q)localObject).cFq();
      }
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, ((q)localObject).bOF(), true);
        label171:
        paramBitmap = ((q)localObject).bOF();
        AppMethodBeat.o(23447);
        return paramBitmap;
        paramBitmap = new int[2];
        Bitmap tmp189_188 = paramBitmap;
        tmp189_188[0] = -1;
        Bitmap tmp193_189 = tmp189_188;
        tmp193_189[1] = -16777216;
        tmp193_189;
      }
      catch (IOException paramBitmap)
      {
        break label171;
      }
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(23446);
    if (this.vgB)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.vgB = true;
    this.kUn = false;
    if ((this.vgC == null) && (!Util.isNullOrNil(paramString3)))
    {
      paramContext.getString(R.l.app_tip);
      this.vgC = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eEd), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ad.this.kUn = true;
        }
      });
      this.vgC.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.ci.a.kr(paramContext)) {
      this.width = com.tencent.mm.ci.a.kr(paramContext);
    }
    this.vgv = LayoutInflater.from(paramContext).inflate(R.i.egS, null);
    this.vgw = ((TextView)this.vgv.findViewById(R.h.dGf));
    this.vgx = ((TextView)this.vgv.findViewById(R.h.dGe));
    this.vgy = ((TextView)this.vgv.findViewById(R.h.dGm));
    this.vgz = ((TextView)this.vgv.findViewById(R.h.dGl));
    this.vgA = this.vgv.findViewById(R.h.dtg);
    this.vgw.setText(paramString1);
    this.vgy.setText(paramString2);
    a.b.a((ImageView)this.vgv.findViewById(R.h.dsd), z.bcZ(), 0.5F, false);
    paramContext = (ImageView)this.vgv.findViewById(R.h.dtf);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.vgv.setLayoutParams(paramString1);
    this.vgv.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.vgv.layout(0, 0, this.width, this.width);
    if (!Util.isNullOrNil(paramString3))
    {
      ae.cZB().a(paramString3, paramContext, new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ad.this.kUn)
          {
            ad.this.vgB = false;
            AppMethodBeat.o(23443);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ad.this.vgC.isShowing()) {
                ad.this.vgC.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ad.this.Y(paramAnonymousb.bitmap);
          parama.avw(paramAnonymousString);
          ad.this.vgB = false;
          AppMethodBeat.o(23443);
        }
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(R.e.darkgrey);
    parama.avw(Y(null));
    this.vgB = false;
    AppMethodBeat.o(23446);
  }
  
  public static abstract interface a
  {
    public abstract void avw(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */