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
import com.tencent.mm.am.af;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.ai;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean gqP;
  private TextView oWA;
  private TextView oWB;
  private TextView oWC;
  private View oWD;
  boolean oWE;
  Dialog oWF;
  private View oWy;
  private TextView oWz;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    af.awe();
    Object localObject = com.tencent.mm.am.e.avD();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = v.sh((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(f.decodeFile(paramString2, null));
      paramString2 = new ry();
      paramString2.dxx.doG = localWXMediaMessage;
      paramString2.dxx.appId = "wx7fa037cc7dfabad5";
      paramString2.dxx.appName = paramContext.getString(2131758621);
      paramString2.dxx.toUser = paramString1;
      paramString2.dxx.dxy = 2;
      if (!bt.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.dxx.dxB = null;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.sdk.b.a.ESL.l(paramString2);
      if (!bt.isNullOrNil(paramString3))
      {
        paramContext = new sb();
        paramContext.dxJ.dxK = paramString1;
        paramContext.dxJ.content = paramString3;
        paramContext.dxJ.type = w.tq(paramString1);
        paramContext.dxJ.flags = 0;
        com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.dxx.dxz = ((String)localObject);
      paramString2.dxx.dxA = str;
    }
  }
  
  public static final String ev(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = q.B(new com.tencent.mm.vfs.e(paramContext.getCacheDir(), "sport_share_bitmap.jpg").fhU());
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  final String U(Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = ai.aC(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ac.3(this, paramBitmap);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.oWD.setBackgroundDrawable(localPaintDrawable);
      this.oWz.setTextColor(paramBitmap[1]);
      this.oWA.setTextColor(paramBitmap[1]);
      this.oWB.setTextColor(paramBitmap[1]);
      this.oWC.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.oWy.draw((Canvas)localObject);
      localObject = new com.tencent.mm.vfs.e(ev(this.context));
      if (((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).delete();
      }
      try
      {
        f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, q.B(((com.tencent.mm.vfs.e)localObject).fhU()), true);
        label174:
        paramBitmap = q.B(((com.tencent.mm.vfs.e)localObject).fhU());
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
    if (this.oWE)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.oWE = true;
    this.gqP = false;
    if ((this.oWF == null) && (!bt.isNullOrNil(paramString3)))
    {
      paramContext.getString(2131755906);
      this.oWF = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131758606), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ac.this.gqP = true;
        }
      });
      this.oWF.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cd.a.hV(paramContext)) {
      this.width = com.tencent.mm.cd.a.hV(paramContext);
    }
    this.oWy = LayoutInflater.from(paramContext).inflate(2131493894, null);
    this.oWz = ((TextView)this.oWy.findViewById(2131299586));
    this.oWA = ((TextView)this.oWy.findViewById(2131299584));
    this.oWB = ((TextView)this.oWy.findViewById(2131299596));
    this.oWC = ((TextView)this.oWy.findViewById(2131299595));
    this.oWD = this.oWy.findViewById(2131297207);
    this.oWz.setText(paramString1);
    this.oWB.setText(paramString2);
    a.b.a((ImageView)this.oWy.findViewById(2131296997), u.aqG(), 0.5F, false);
    paramContext = (ImageView)this.oWy.findViewById(2131297204);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.oWy.setLayoutParams(paramString1);
    this.oWy.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.oWy.layout(0, 0, this.width, this.width);
    if (!bt.isNullOrNil(paramString3))
    {
      ad.bZJ().a(paramString3, paramContext, new com.tencent.mm.aw.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ac.this.gqP)
          {
            ac.this.oWE = false;
            AppMethodBeat.o(23443);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ac.this.oWF.isShowing()) {
                ac.this.oWF.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ac.this.U(paramAnonymousb.bitmap);
          parama.UF(paramAnonymousString);
          ac.this.oWE = false;
          AppMethodBeat.o(23443);
        }
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(2131100204);
    parama.UF(U(null));
    this.oWE = false;
    AppMethodBeat.o(23446);
  }
  
  public static abstract interface a
  {
    public abstract void UF(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */