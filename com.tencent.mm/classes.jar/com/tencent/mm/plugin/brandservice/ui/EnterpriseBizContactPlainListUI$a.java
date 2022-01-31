package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.cb.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;

final class EnterpriseBizContactPlainListUI$a
  extends r<jt>
  implements m.b
{
  b ffG = new b(new EnterpriseBizContactPlainListUI.a.1(this));
  private b.b ffH = null;
  
  public EnterpriseBizContactPlainListUI$a(EnterpriseBizContactPlainListUI paramEnterpriseBizContactPlainListUI, Context paramContext)
  {
    super(paramContext, new jt());
    yc();
  }
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
    ai.d(new EnterpriseBizContactPlainListUI.a.2(this));
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.ffH == null) {
      this.ffH = new b.b()
      {
        public final int WL()
        {
          return EnterpriseBizContactPlainListUI.a.this.getCount();
        }
        
        public final String jX(int paramAnonymousInt)
        {
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= EnterpriseBizContactPlainListUI.a.this.getCount()))
          {
            y.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
            return null;
          }
          jt localjt = (jt)EnterpriseBizContactPlainListUI.a.this.getItem(paramAnonymousInt);
          if (localjt == null) {
            return null;
          }
          return localjt.userName;
        }
      };
    }
    if (this.ffG != null) {
      this.ffG.a(paramInt, this.ffH);
    }
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.context, b.e.enterprise_biz_list_item_normal, null);
      paramViewGroup.ffK = ((ImageView)paramView.findViewById(b.d.nearby_friend_avatar_iv));
      paramViewGroup.fdY = ((TextView)paramView.findViewById(b.d.nearby_friend_name));
      paramView.setTag(paramViewGroup);
    }
    jt localjt;
    for (;;)
    {
      localjt = (jt)getItem(paramInt);
      if (localjt != null) {
        break;
      }
      paramViewGroup.clear();
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.clear();
    paramInt = paramView.getPaddingBottom();
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    paramView.setBackgroundDrawable(a.g(this.context, b.c.comm_list_item_selector));
    paramView.setPadding(k, i, j, paramInt);
    String str = bk.pm(localjt.dnp.Bp());
    paramViewGroup.fdY.setText(j.a(this.context, str, paramViewGroup.fdY.getTextSize()));
    paramViewGroup.fdY.setVisibility(0);
    paramViewGroup.ffK.setVisibility(0);
    if (!bk.bl(localjt.dnp.field_username))
    {
      a.b.a(paramViewGroup.ffK, localjt.dnp.field_username);
      return paramView;
    }
    paramViewGroup.ffK.setImageDrawable(null);
    return paramView;
  }
  
  public final void yc()
  {
    StringBuilder localStringBuilder = null;
    if (!g.DK())
    {
      y.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
      return;
    }
    bcS();
    Object localObject;
    switch (EnterpriseBizContactPlainListUI.b(this.idM))
    {
    default: 
      z.My();
      localObject = com.tencent.mm.ai.e.C(EnterpriseBizContactPlainListUI.c(this.idM), true);
    }
    for (;;)
    {
      setCursor((Cursor)localObject);
      return;
      z.My();
      localObject = com.tencent.mm.ai.e.N(EnterpriseBizContactPlainListUI.c(this.idM), 25);
      continue;
      z.My();
      localObject = EnterpriseBizContactPlainListUI.c(this.idM);
      localStringBuilder = new StringBuilder();
      com.tencent.mm.ai.e.b(localStringBuilder);
      com.tencent.mm.ai.e.c(localStringBuilder);
      com.tencent.mm.ai.e.a(localStringBuilder, (String)localObject);
      com.tencent.mm.ai.e.b(localStringBuilder, false);
      com.tencent.mm.ai.e.a(localStringBuilder, false);
      localStringBuilder.append(" order by ");
      localStringBuilder.append(com.tencent.mm.ai.e.Me());
      localObject = localStringBuilder.toString();
      y.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[] { localObject });
      localObject = g.DP().dKu.a((String)localObject, null, 0);
      continue;
      z.My();
      localObject = com.tencent.mm.ai.e.N(EnterpriseBizContactPlainListUI.c(this.idM), 128);
      continue;
      d locald = f.kX(EnterpriseBizContactPlainListUI.c(this.idM));
      localObject = localStringBuilder;
      if (locald != null)
      {
        localObject = localStringBuilder;
        if (locald.field_enterpriseFather != null) {
          localObject = z.My().kR(locald.field_enterpriseFather);
        }
      }
    }
  }
  
  protected final void yd()
  {
    yc();
  }
  
  final class a
  {
    TextView fdY;
    ImageView ffK;
    
    a() {}
    
    public final void clear()
    {
      if (this.ffK != null)
      {
        this.ffK.setImageDrawable(null);
        this.ffK.setVisibility(8);
      }
      if (this.fdY != null)
      {
        this.fdY.setText("");
        this.fdY.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a
 * JD-Core Version:    0.7.0.1
 */