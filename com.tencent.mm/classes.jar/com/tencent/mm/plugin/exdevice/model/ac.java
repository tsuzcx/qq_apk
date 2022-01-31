package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean eUJ;
  private View lFN;
  private TextView lFO;
  private TextView lFP;
  private TextView lFQ;
  private TextView lFR;
  private View lFS;
  boolean lFT;
  Dialog lFU;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(19380);
    z.afi();
    Object localObject = e.aeN();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = s.nE((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(d.decodeFile(paramString2, null));
      paramString2 = new qg();
      paramString2.cGL.cyF = localWXMediaMessage;
      paramString2.cGL.appId = "wx7fa037cc7dfabad5";
      paramString2.cGL.appName = paramContext.getString(2131299490);
      paramString2.cGL.toUser = paramString1;
      paramString2.cGL.cGM = 2;
      if (!bo.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.cGL.cGP = null;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.sdk.b.a.ymk.l(paramString2);
      if (!bo.isNullOrNil(paramString3))
      {
        paramContext = new qj();
        paramContext.cGX.cGY = paramString1;
        paramContext.cGX.content = paramString3;
        paramContext.cGX.type = t.oF(paramString1);
        paramContext.cGX.flags = 0;
        com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      }
      AppMethodBeat.o(19380);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.cGL.cGN = ((String)localObject);
      paramString2.cGL.cGO = str;
    }
  }
  
  public static final String dL(Context paramContext)
  {
    AppMethodBeat.i(19377);
    paramContext = new File(paramContext.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
    AppMethodBeat.o(19377);
    return paramContext;
  }
  
  final String J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(19379);
    if (paramBitmap != null) {
      paramBitmap = af.ao(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ac.3(this, paramBitmap);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.lFS.setBackgroundDrawable(localPaintDrawable);
      this.lFO.setTextColor(paramBitmap[1]);
      this.lFP.setTextColor(paramBitmap[1]);
      this.lFQ.setTextColor(paramBitmap[1]);
      this.lFR.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.lFN.draw((Canvas)localObject);
      localObject = new File(dL(this.context));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      try
      {
        d.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, ((File)localObject).getAbsolutePath(), true);
        label170:
        paramBitmap = ((File)localObject).getAbsolutePath();
        AppMethodBeat.o(19379);
        return paramBitmap;
        paramBitmap = new int[2];
        Bitmap tmp188_187 = paramBitmap;
        tmp188_187[0] = -1;
        Bitmap tmp192_188 = tmp188_187;
        tmp192_188[1] = -16777216;
        tmp192_188;
      }
      catch (IOException paramBitmap)
      {
        break label170;
      }
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, ac.a parama)
  {
    AppMethodBeat.i(19378);
    if (this.lFT)
    {
      AppMethodBeat.o(19378);
      return;
    }
    this.lFT = true;
    this.eUJ = false;
    if ((this.lFU == null) && (!bo.isNullOrNil(paramString3)))
    {
      paramContext.getString(2131297087);
      this.lFU = h.b(paramContext, paramContext.getString(2131299475), true, new ac.1(this));
      this.lFU.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cb.a.gw(paramContext)) {
      this.width = com.tencent.mm.cb.a.gw(paramContext);
    }
    this.lFN = LayoutInflater.from(paramContext).inflate(2130969482, null);
    this.lFO = ((TextView)this.lFN.findViewById(2131823835));
    this.lFP = ((TextView)this.lFN.findViewById(2131823848));
    this.lFQ = ((TextView)this.lFN.findViewById(2131823846));
    this.lFR = ((TextView)this.lFN.findViewById(2131823849));
    this.lFS = this.lFN.findViewById(2131823844);
    this.lFO.setText(paramString1);
    this.lFQ.setText(paramString2);
    a.b.a((ImageView)this.lFN.findViewById(2131823768), r.Zn(), 0.5F, false);
    paramContext = (ImageView)this.lFN.findViewById(2131823843);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.lFN.setLayoutParams(paramString1);
    this.lFN.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.lFN.layout(0, 0, this.width, this.width);
    if (!bo.isNullOrNil(paramString3))
    {
      ad.bqb().a(paramString3, paramContext, new ac.2(this, parama));
      AppMethodBeat.o(19378);
      return;
    }
    paramContext.setImageResource(2131689922);
    parama.Lw(J(null));
    this.lFT = false;
    AppMethodBeat.o(19378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */