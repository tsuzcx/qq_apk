package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.as.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends com.tencent.mm.ui.r<com.tencent.mm.plugin.masssend.a.a>
{
  private static short mbd = 1;
  private static short mbe = 2;
  private static short mbf = 3;
  private static short mbg = 4;
  private MMActivity bER;
  int dsw;
  private LayoutInflater fhz;
  int iwi;
  private short[] mbh;
  private List<String> mbi;
  String mbj = "";
  c.e mbk;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    this.bER = ((MMActivity)paramContext);
    this.mbi = new LinkedList();
    this.iwi = 10;
    this.dsw = this.iwi;
    this.fhz = com.tencent.mm.ui.y.gt(paramContext);
  }
  
  private static int oq(int paramInt)
  {
    if (paramInt <= 2) {
      return 100;
    }
    if (paramInt < 10) {
      return (paramInt - 2) * 8 + 100;
    }
    if (paramInt < 60) {
      return (paramInt / 10 + 7) * 8 + 100;
    }
    return 204;
  }
  
  public final void GV(String paramString)
  {
    this.mbj = paramString;
    notifyDataSetChanged();
  }
  
  public final boolean aCc()
  {
    return this.iwi >= this.dsw;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (com.tencent.mm.plugin.masssend.a.a)getItem(paramInt);
    int i;
    int j;
    label76:
    label96:
    label120:
    Object localObject2;
    if (paramInt != 0)
    {
      long l1 = ((com.tencent.mm.plugin.masssend.a.a)getItem(paramInt - 1)).createTime;
      paramViewGroup = (com.tencent.mm.plugin.masssend.a.a)getItem(paramInt);
      long l2 = paramViewGroup.createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label492;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label498;
        }
        this.mbh[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.mbh[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
          break label521;
        }
        paramInt = 1;
        switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
        {
        default: 
          paramViewGroup = paramView;
          label170:
          paramView = (c.f)paramViewGroup.getTag();
          label256:
          if (paramInt != 0)
          {
            paramView.kZl.setVisibility(0);
            paramView.kZl.setText(com.tencent.mm.pluginsdk.f.h.c(this.bER, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label210:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (c.f)paramViewGroup.getTag();
              ((c.f)localObject2).mbm.setText(this.bER.getResources().getQuantityString(R.j.mass_send_contact_count, ((com.tencent.mm.plugin.masssend.a.a)localObject1).maG, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).maG) }));
              if (this.mbi.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).bgV()))
              {
                ((c.f)localObject2).mbn.setSingleLine(false);
                ((c.f)localObject2).mbn.setEllipsize(null);
              }
              break;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      Object localObject3 = ((c.f)localObject2).mbn;
      MMActivity localMMActivity = this.bER;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).bgY() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).bgY().equals(""))) {
        break label1749;
      }
      paramView = "";
      ((TextView)localObject3).setText(j.a(localMMActivity, paramView, ((c.f)localObject2).mbn.getTextSize()));
      paramInt = (int)((c.f)localObject2).mbn.getTextSize();
      paramView = ((c.f)localObject2).mbn.getText().toString();
      com.tencent.mm.cb.a.fromDPToPix(this.bER, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((c.f)localObject2).mbr.setOnClickListener(new c.b(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bgV()));
      return paramViewGroup;
      i = 0;
      break;
      label492:
      j = 0;
      break label76;
      label498:
      this.mbh[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label96;
      this.mbh[paramInt] = 1;
      break label96;
      label521:
      paramInt = 0;
      break label120;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).mbu == mbd) {
          break label170;
        }
      }
      paramViewGroup = this.fhz.inflate(R.i.mass_send_item_text, null);
      ((c.f)localObject2).mbm = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_contact_count));
      ((c.f)localObject2).mbn = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_text_contact));
      ((c.f)localObject2).mbo = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_text_content));
      ((c.f)localObject2).mbr = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_compose));
      ((c.f)localObject2).kZl = ((TextView)paramViewGroup.findViewById(R.h.mass_send_itme_time_tv));
      ((c.f)localObject2).mbt = paramViewGroup.findViewById(R.h.mass_send_item_contact_area);
      ((c.f)localObject2).mbu = mbd;
      paramViewGroup.setTag(localObject2);
      break label170;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).mbu == mbg) {
          break label170;
        }
      }
      paramViewGroup = this.fhz.inflate(R.i.mass_send_item_voice, null);
      ((c.f)localObject2).mbm = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_contact_count));
      ((c.f)localObject2).mbn = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_text_contact));
      ((c.f)localObject2).mbq = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_length));
      ((c.f)localObject2).mbo = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_voice_content));
      ((c.f)localObject2).mbs = ((AnimImageView)paramViewGroup.findViewById(R.h.mass_send_item_voice_anim));
      ((c.f)localObject2).mbr = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_compose));
      ((c.f)localObject2).kZl = ((TextView)paramViewGroup.findViewById(R.h.mass_send_itme_time_tv));
      ((c.f)localObject2).mbt = paramViewGroup.findViewById(R.h.mass_send_item_contact_area);
      ((c.f)localObject2).mbu = mbg;
      paramViewGroup.setTag(localObject2);
      break label170;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).mbu == mbe) {
          break label170;
        }
      }
      paramViewGroup = this.fhz.inflate(R.i.mass_send_item_img, null);
      ((c.f)localObject2).mbm = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_contact_count));
      ((c.f)localObject2).mbn = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_text_contact));
      ((c.f)localObject2).kcc = ((ImageView)paramViewGroup.findViewById(R.h.mass_send_item_thumb));
      ((c.f)localObject2).mbr = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_compose));
      ((c.f)localObject2).kZl = ((TextView)paramViewGroup.findViewById(R.h.mass_send_itme_time_tv));
      ((c.f)localObject2).mbt = paramViewGroup.findViewById(R.h.mass_send_item_contact_area);
      ((c.f)localObject2).mbu = mbe;
      paramViewGroup.setTag(localObject2);
      break label170;
      localObject2 = new c.f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((c.f)paramView.getTag()).mbu == mbf) {
          break label170;
        }
      }
      paramViewGroup = this.fhz.inflate(R.i.mass_send_item_video, null);
      ((c.f)localObject2).mbm = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_contact_count));
      ((c.f)localObject2).mbn = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_text_contact));
      ((c.f)localObject2).kcc = ((ImageView)paramViewGroup.findViewById(R.h.mass_send_item_thumb));
      ((c.f)localObject2).mbq = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_video_length));
      ((c.f)localObject2).mbr = ((TextView)paramViewGroup.findViewById(R.h.mass_send_item_compose));
      ((c.f)localObject2).kZl = ((TextView)paramViewGroup.findViewById(R.h.mass_send_itme_time_tv));
      ((c.f)localObject2).mbt = paramViewGroup.findViewById(R.h.mass_send_item_contact_area);
      ((c.f)localObject2).mbu = mbf;
      paramViewGroup.setTag(localObject2);
      break label170;
      paramView.kZl.setVisibility(8);
      break label210;
      paramView = (c.f)paramViewGroup.getTag();
      paramView.mbo.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).bgW());
      j.h(paramView.mbo, 1);
      break label256;
      paramView = (c.f)paramViewGroup.getTag();
      float f = q.ck(((com.tencent.mm.plugin.masssend.a.a)localObject1).maH);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).bgV().equals(this.mbj))
      {
        paramView.mbs.setVisibility(0);
        paramView.mbs.cAq();
        paramView.mbo.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.mbq.setText(this.bER.getString(R.l.fmt_time_length, new Object[] { Integer.valueOf((int)f) }));
        paramView.mbo.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.mbo.getContext(), oq((int)f)));
        paramView.mbs.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.mbo.getContext(), oq((int)f)));
        paramView.mbo.setOnClickListener(new c.d(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bgV()));
        break;
        paramView.mbs.setVisibility(8);
        paramView.mbs.bvP();
        paramView.mbo.setCompoundDrawablesWithIntrinsicBounds(null, null, this.bER.getResources().getDrawable(R.k.chatto_voice_playing), null);
      }
      paramView = (c.f)paramViewGroup.getTag();
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.plugin.masssend.a.h.bhd();
        localObject2 = b.GR(((com.tencent.mm.plugin.masssend.a.a)localObject1).bgW());
        if (localObject2 != null) {
          paramView.kcc.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.kcc.setOnClickListener(new c.a(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bgW(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).maK));
        break;
        com.tencent.mm.plugin.masssend.a.h.bhd();
        localObject2 = b.d(((com.tencent.mm.plugin.masssend.a.a)localObject1).bgX(), com.tencent.mm.cb.a.getDensity(paramView.kcc.getContext()));
        paramView.kcc.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.kcc.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, R.g.nosdcard_chatting_bg));
      }
      paramView = (c.f)paramViewGroup.getTag();
      com.tencent.mm.modelvideo.o.Sr();
      localObject2 = t.nT(((com.tencent.mm.plugin.masssend.a.a)localObject1).bgW());
      localObject2 = com.tencent.mm.as.o.OJ().a((String)localObject2, com.tencent.mm.cb.a.getDensity(paramView.kcc.getContext()), this.bER);
      if (localObject2 == null)
      {
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.kcc.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, R.k.video_no_sd_icon));
        }
      }
      for (;;)
      {
        paramView.kcc.setOnClickListener(new c.c(this, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bgW(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).bvi, ((com.tencent.mm.plugin.masssend.a.a)localObject1).maH));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1700;
        }
        paramView.mbq.setVisibility(8);
        break;
        paramView.kcc.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, R.e.grey_color_01));
        continue;
        paramView.kcc.setImageBitmap((Bitmap)localObject2);
      }
      label1700:
      paramView.mbq.setVisibility(0);
      paramView.mbq.setText(bk.jL(((com.tencent.mm.plugin.masssend.a.a)localObject1).maH));
      break label256;
      ((c.f)localObject2).mbn.setSingleLine(true);
      ((c.f)localObject2).mbn.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1749:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).bgY().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = bk.G((String[])localObject4);
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramView = "";
        break;
      }
      localObject4 = new StringBuilder();
      paramInt = 0;
      if (paramInt < paramView.size())
      {
        String str = com.tencent.mm.model.r.gV((String)paramView.get(paramInt));
        if (paramInt == paramView.size() - 1) {
          ((StringBuilder)localObject4).append(str);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          ((StringBuilder)localObject4).append(str + ", ");
        }
      }
      paramView = ((StringBuilder)localObject4).toString();
      break;
    }
  }
  
  public final void yc()
  {
    Object localObject = com.tencent.mm.plugin.masssend.a.h.bhd().dXo.a("SELECT count(*) FROM massendinfo", null, 2);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      this.dsw = i;
      localObject = com.tencent.mm.plugin.masssend.a.h.bhd();
      i = this.iwi;
      String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i + " offset (SELECT count(*) FROM massendinfo ) -" + i;
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.MasSendInfoStorage", "getCursor sql:" + str);
      setCursor(((b)localObject).dXo.a(str, null, 0));
      i = getCount();
      if (i > 0) {
        this.mbh = new short[i];
      }
      super.notifyDataSetChanged();
      return;
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */