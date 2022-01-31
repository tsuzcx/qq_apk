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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean edT;
  private View jwo;
  private TextView jwp;
  private TextView jwq;
  private TextView jwr;
  private TextView jws;
  private View jwt;
  boolean jwu;
  Dialog jwv;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    z.My();
    Object localObject = e.Mg();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = r.gV((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(c.decodeFile(paramString2, null));
      paramString2 = new pb();
      paramString2.bYE.bRd = localWXMediaMessage;
      paramString2.bYE.appId = "wx7fa037cc7dfabad5";
      paramString2.bYE.appName = paramContext.getString(R.l.exdevice_wechat_sport);
      paramString2.bYE.toUser = paramString1;
      paramString2.bYE.bYF = 2;
      if (!bk.bl((String)localObject)) {
        break label242;
      }
      paramString2.bYE.bYI = null;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.sdk.b.a.udP.m(paramString2);
      if (!bk.bl(paramString3))
      {
        paramContext = new pe();
        paramContext.bYQ.bYR = paramString1;
        paramContext.bYQ.content = paramString3;
        paramContext.bYQ.type = s.hW(paramString1);
        paramContext.bYQ.flags = 0;
        com.tencent.mm.sdk.b.a.udP.m(paramContext);
      }
      return bool;
      localObject = null;
      break;
      label242:
      paramString2.bYE.bYG = ((String)localObject);
      paramString2.bYE.bYH = str;
    }
  }
  
  public static final String cZ(Context paramContext)
  {
    return new File(paramContext.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, final ac.a parama)
  {
    if (this.jwu) {
      return;
    }
    this.jwu = true;
    this.edT = false;
    if ((this.jwv == null) && (!bk.bl(paramString3)))
    {
      paramContext.getString(R.l.app_tip);
      this.jwv = h.b(paramContext, paramContext.getString(R.l.exdevice_sport_downloading_cover), true, new ac.1(this));
      this.jwv.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cb.a.fj(paramContext)) {
      this.width = com.tencent.mm.cb.a.fj(paramContext);
    }
    this.jwo = LayoutInflater.from(paramContext).inflate(R.i.exdevice_share_view, null);
    this.jwp = ((TextView)this.jwo.findViewById(R.h.exdevice_rank_tv));
    this.jwq = ((TextView)this.jwo.findViewById(R.h.exdevice_rank_info_tv));
    this.jwr = ((TextView)this.jwo.findViewById(R.h.exdevice_user_score_tv));
    this.jws = ((TextView)this.jwo.findViewById(R.h.exdevice_user_score_info_tv));
    this.jwt = this.jwo.findViewById(R.h.bg_mask);
    this.jwp.setText(paramString1);
    this.jwr.setText(paramString2);
    a.b.a((ImageView)this.jwo.findViewById(R.h.avatarIV), q.Gj(), 0.5F, false);
    paramContext = (ImageView)this.jwo.findViewById(R.h.bgIV);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jwo.setLayoutParams(paramString1);
    this.jwo.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.jwo.layout(0, 0, this.width, this.width);
    if (!bk.bl(paramString3))
    {
      ad.aLO().a(paramString3, paramContext, new g()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          if (ac.this.edT)
          {
            ac.this.jwu = false;
            return;
          }
          ai.d(new Runnable()
          {
            public final void run()
            {
              if (ac.this.jwv.isShowing()) {
                ac.this.jwv.dismiss();
              }
            }
          });
          paramAnonymousString = ac.this.y(paramAnonymousb.bitmap);
          parama.Bu(paramAnonymousString);
          ac.this.jwu = false;
        }
        
        public final void mv(String paramAnonymousString) {}
      });
      return;
    }
    paramContext.setImageResource(R.e.darkgrey);
    parama.Bu(y(null));
    this.jwu = false;
  }
  
  final String y(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramBitmap = ak.Y(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ac.3(this, paramBitmap);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.jwt.setBackgroundDrawable(localPaintDrawable);
      this.jwp.setTextColor(paramBitmap[1]);
      this.jwq.setTextColor(paramBitmap[1]);
      this.jwr.setTextColor(paramBitmap[1]);
      this.jws.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.jwo.draw((Canvas)localObject);
      localObject = new File(cZ(this.context));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      try
      {
        c.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, ((File)localObject).getAbsolutePath(), true);
        label164:
        return ((File)localObject).getAbsolutePath();
        paramBitmap = new int[2];
        Bitmap tmp174_173 = paramBitmap;
        tmp174_173[0] = -1;
        Bitmap tmp178_174 = tmp174_173;
        tmp178_174[1] = -16777216;
        tmp178_174;
      }
      catch (IOException paramBitmap)
      {
        break label164;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */