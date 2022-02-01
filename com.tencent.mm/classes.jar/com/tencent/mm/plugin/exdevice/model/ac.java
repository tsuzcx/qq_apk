package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
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
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.aj;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean gRx;
  private View pzJ;
  private TextView pzK;
  private TextView pzL;
  private TextView pzM;
  private TextView pzN;
  private View pzO;
  boolean pzP;
  Dialog pzQ;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    af.aCW();
    Object localObject = com.tencent.mm.al.e.aCv();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = v.wk((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(f.decodeFile(paramString2, null));
      paramString2 = new sh();
      paramString2.dvk.dis = localWXMediaMessage;
      paramString2.dvk.appId = "wx7fa037cc7dfabad5";
      paramString2.dvk.appName = paramContext.getString(2131758621);
      paramString2.dvk.toUser = paramString1;
      paramString2.dvk.dit = 2;
      if (!bs.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.dvk.dvn = null;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.sdk.b.a.GpY.l(paramString2);
      if (!bs.isNullOrNil(paramString3))
      {
        paramContext = new sk();
        paramContext.dvv.dvw = paramString1;
        paramContext.dvv.content = paramString3;
        paramContext.dvv.type = w.xt(paramString1);
        paramContext.dvv.flags = 0;
        com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.dvk.dvl = ((String)localObject);
      paramString2.dvk.dvm = str;
    }
  }
  
  public static final String eD(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = q.B(new com.tencent.mm.vfs.e(paramContext.getCacheDir(), "sport_share_bitmap.jpg").fxV());
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  final String U(Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = aj.aE(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ac.3(this, paramBitmap);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.pzO.setBackgroundDrawable(localPaintDrawable);
      this.pzK.setTextColor(paramBitmap[1]);
      this.pzL.setTextColor(paramBitmap[1]);
      this.pzM.setTextColor(paramBitmap[1]);
      this.pzN.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.pzJ.draw((Canvas)localObject);
      localObject = new com.tencent.mm.vfs.e(eD(this.context));
      if (((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).delete();
      }
      try
      {
        f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, q.B(((com.tencent.mm.vfs.e)localObject).fxV()), true);
        label174:
        paramBitmap = q.B(((com.tencent.mm.vfs.e)localObject).fxV());
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
    if (this.pzP)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.pzP = true;
    this.gRx = false;
    if ((this.pzQ == null) && (!bs.isNullOrNil(paramString3)))
    {
      paramContext.getString(2131755906);
      this.pzQ = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131758606), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ac.this.gRx = true;
        }
      });
      this.pzQ.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cc.a.ig(paramContext)) {
      this.width = com.tencent.mm.cc.a.ig(paramContext);
    }
    this.pzJ = LayoutInflater.from(paramContext).inflate(2131493894, null);
    this.pzK = ((TextView)this.pzJ.findViewById(2131299586));
    this.pzL = ((TextView)this.pzJ.findViewById(2131299584));
    this.pzM = ((TextView)this.pzJ.findViewById(2131299596));
    this.pzN = ((TextView)this.pzJ.findViewById(2131299595));
    this.pzO = this.pzJ.findViewById(2131297207);
    this.pzK.setText(paramString1);
    this.pzM.setText(paramString2);
    a.b.a((ImageView)this.pzJ.findViewById(2131296997), u.axw(), 0.5F, false);
    paramContext = (ImageView)this.pzJ.findViewById(2131297204);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.pzJ.setLayoutParams(paramString1);
    this.pzJ.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.pzJ.layout(0, 0, this.width, this.width);
    if (!bs.isNullOrNil(paramString3))
    {
      ad.cgS().a(paramString3, paramContext, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ac.this.gRx)
          {
            ac.this.pzP = false;
            AppMethodBeat.o(23443);
            return;
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ac.this.pzQ.isShowing()) {
                ac.this.pzQ.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ac.this.U(paramAnonymousb.bitmap);
          parama.YR(paramAnonymousString);
          ac.this.pzP = false;
          AppMethodBeat.o(23443);
        }
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(2131100204);
    parama.YR(U(null));
    this.pzP = false;
    AppMethodBeat.o(23446);
  }
  
  public static abstract interface a
  {
    public abstract void YR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */