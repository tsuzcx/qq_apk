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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.vfs.k;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean hmD;
  private View qjT;
  private TextView qjU;
  private TextView qjV;
  private TextView qjW;
  private TextView qjX;
  private View qjY;
  boolean qjZ;
  Dialog qka;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    ag.aGp();
    Object localObject = f.aFO();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = com.tencent.mm.model.w.zP((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(com.tencent.mm.sdk.platformtools.h.decodeFile(paramString2, null));
      paramString2 = new sv();
      paramString2.dIs.dve = localWXMediaMessage;
      paramString2.dIs.appId = "wx7fa037cc7dfabad5";
      paramString2.dIs.appName = paramContext.getString(2131758621);
      paramString2.dIs.toUser = paramString1;
      paramString2.dIs.dvf = 2;
      if (!bu.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.dIs.dIv = null;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.sdk.b.a.IvT.l(paramString2);
      if (!bu.isNullOrNil(paramString3))
      {
        paramContext = new sy();
        paramContext.dID.cUB = paramString1;
        paramContext.dID.content = paramString3;
        paramContext.dID.type = x.Bb(paramString1);
        paramContext.dID.flags = 0;
        com.tencent.mm.sdk.b.a.IvT.l(paramContext);
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.dIs.dIt = ((String)localObject);
      paramString2.dIs.dIu = str;
    }
  }
  
  public static final String eH(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = com.tencent.mm.vfs.w.B(new k(paramContext.getCacheDir(), "sport_share_bitmap.jpg").fTh());
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  final String V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = al.aH(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ac.3(this, paramBitmap);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.qjY.setBackgroundDrawable(localPaintDrawable);
      this.qjU.setTextColor(paramBitmap[1]);
      this.qjV.setTextColor(paramBitmap[1]);
      this.qjW.setTextColor(paramBitmap[1]);
      this.qjX.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.qjT.draw((Canvas)localObject);
      localObject = new k(eH(this.context));
      if (((k)localObject).exists()) {
        ((k)localObject).delete();
      }
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, com.tencent.mm.vfs.w.B(((k)localObject).fTh()), true);
        label174:
        paramBitmap = com.tencent.mm.vfs.w.B(((k)localObject).fTh());
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
    if (this.qjZ)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.qjZ = true;
    this.hmD = false;
    if ((this.qka == null) && (!bu.isNullOrNil(paramString3)))
    {
      paramContext.getString(2131755906);
      this.qka = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131758606), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ac.this.hmD = true;
        }
      });
      this.qka.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cb.a.iu(paramContext)) {
      this.width = com.tencent.mm.cb.a.iu(paramContext);
    }
    this.qjT = LayoutInflater.from(paramContext).inflate(2131493894, null);
    this.qjU = ((TextView)this.qjT.findViewById(2131299586));
    this.qjV = ((TextView)this.qjT.findViewById(2131299584));
    this.qjW = ((TextView)this.qjT.findViewById(2131299596));
    this.qjX = ((TextView)this.qjT.findViewById(2131299595));
    this.qjY = this.qjT.findViewById(2131297207);
    this.qjU.setText(paramString1);
    this.qjW.setText(paramString2);
    a.b.a((ImageView)this.qjT.findViewById(2131296997), v.aAC(), 0.5F, false);
    paramContext = (ImageView)this.qjT.findViewById(2131297204);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.qjT.setLayoutParams(paramString1);
    this.qjT.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.qjT.layout(0, 0, this.width, this.width);
    if (!bu.isNullOrNil(paramString3))
    {
      ad.cmM().a(paramString3, paramContext, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ac.this.hmD)
          {
            ac.this.qjZ = false;
            AppMethodBeat.o(23443);
            return;
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ac.this.qka.isShowing()) {
                ac.this.qka.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ac.this.V(paramAnonymousb.bitmap);
          parama.ado(paramAnonymousString);
          ac.this.qjZ = false;
          AppMethodBeat.o(23443);
        }
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(2131100204);
    parama.ado(V(null));
    this.qjZ = false;
    AppMethodBeat.o(23446);
  }
  
  public static abstract interface a
  {
    public abstract void ado(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */