package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.i;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private int drX;
  List<q> hfb;
  r.c ibN = new f.1(this);
  boolean ifk = false;
  private BizTimeLineNewMsgUI igu;
  boolean igv = false;
  
  public f(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<q> paramList, int paramInt)
  {
    this.igu = paramBizTimeLineNewMsgUI;
    z.MF().a(this.ibN, Looper.getMainLooper());
    this.hfb = paramList;
    this.drX = paramInt;
  }
  
  public final q axL()
  {
    if (this.hfb.size() > 0) {
      return (q)this.hfb.get(this.hfb.size() - 1);
    }
    return null;
  }
  
  public final int getCount()
  {
    return this.hfb.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = oy(paramInt);
    if (localObject == null)
    {
      y.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      paramViewGroup = new f.a();
      localView = View.inflate(this.igu, b.e.biz_time_line_new_msg_item, null);
      paramViewGroup.dpY = ((ImageView)localView.findViewById(b.d.avatar_iv));
      paramViewGroup.feh = ((TextView)localView.findViewById(b.d.nick_name_tv));
      paramViewGroup.igx = ((TextView)localView.findViewById(b.d.time_tv));
      paramViewGroup.eXr = ((TextView)localView.findViewById(b.d.title_tv));
      paramViewGroup.hgH = localView.findViewById(b.d.bottom_line);
      localView.setTag(paramViewGroup);
      a.b.a(paramViewGroup.dpY, ((q)localObject).field_talker);
      paramView = r.gV(((q)localObject).field_talker);
      paramViewGroup.feh.setText(j.a(this.igu, paramView, paramViewGroup.feh.getTextSize()));
      paramViewGroup.igx.setText(b.e(this.igu, ((q)localObject).field_createTime));
      if (!((q)localObject).ctz()) {
        break label249;
      }
      paramViewGroup.eXr.setText(i.gt(((q)localObject).field_content));
      label209:
      if (paramInt != getCount() - 1) {
        break label863;
      }
      paramViewGroup.hgH.setVisibility(4);
    }
    for (;;)
    {
      oz(paramInt);
      return localView;
      paramViewGroup = (f.a)paramView.getTag();
      localView = paramView;
      break;
      label249:
      if (!((q)localObject).isText()) {
        if (((q)localObject).field_type != 10000) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label312;
        }
        paramViewGroup.eXr.setText(j.a(this.igu, ((q)localObject).field_content, (int)paramViewGroup.eXr.getTextSize()));
        break;
      }
      label312:
      if (((q)localObject).ctB())
      {
        paramViewGroup.eXr.setText(this.igu.getString(b.h.app_pic));
        break label209;
      }
      if (((q)localObject).ctA())
      {
        paramViewGroup.eXr.setText(this.igu.getString(b.h.app_voice));
        break label209;
      }
      if (((q)localObject).field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label412;
        }
        paramViewGroup.eXr.setText(this.igu.getString(b.h.app_video));
        break;
      }
      label412:
      if ((((q)localObject).field_type == 42) || (((q)localObject).field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label466;
        }
        paramViewGroup.eXr.setText(this.igu.getString(b.h.app_product_card_ticket));
        break;
      }
      label466:
      label482:
      g.a locala;
      if ((((q)localObject).field_type & 0xFFFF) == 49)
      {
        i = 1;
        if (i == 0) {
          break label843;
        }
        locala = g.a.gp(((q)localObject).field_content);
        if (locala == null) {
          break label843;
        }
        paramView = "";
        switch (locala.type)
        {
        }
      }
      for (;;)
      {
        localObject = paramView;
        if (bk.bl(paramView)) {
          localObject = locala.getTitle();
        }
        paramViewGroup.eXr.setText(j.a(this.igu, (CharSequence)localObject, paramViewGroup.eXr.getTextSize()));
        break;
        i = 0;
        break label482;
        paramView = locala.title;
        continue;
        paramView = this.igu.getString(b.h.app_pic);
        continue;
        paramView = this.igu.getString(b.h.app_music) + locala.title;
        continue;
        paramView = this.igu.getString(b.h.app_video) + locala.title;
        continue;
        paramView = this.igu.getString(b.h.app_url) + locala.getTitle();
        continue;
        paramView = this.igu.getString(b.h.app_product_card_ticket) + locala.getTitle();
        continue;
        paramView = "[" + locala.dSf + "]" + locala.dSb;
      }
      label843:
      paramViewGroup.eXr.setText(this.igu.getString(b.h.biz_time_line_item_un_support_type));
      break label209;
      label863:
      paramViewGroup.hgH.setVisibility(0);
    }
  }
  
  public final q oy(int paramInt)
  {
    if (paramInt < this.hfb.size()) {
      return (q)this.hfb.get(paramInt);
    }
    return null;
  }
  
  public final void oz(int paramInt)
  {
    if ((this.drX == 1) && (!this.igv)) {}
    while ((paramInt != getCount() - 1) || (this.ifk)) {
      return;
    }
    ai.l(new f.2(this, paramInt), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */