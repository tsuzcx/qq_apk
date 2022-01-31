package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

public final class c
  extends b
{
  private final String fXS;
  private AuthorizeItemListView fXT;
  private LinearLayout fXV;
  private c.b hsq;
  private final String mAppName;
  private Context mContext;
  
  public c(Context paramContext, LinkedList<bna> paramLinkedList, String paramString1, String paramString2, c.a parama)
  {
    super(paramContext, (byte)0);
    this.mContext = paramContext;
    this.mAppName = bk.pm(paramString1);
    this.fXS = paramString2;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      throw new IllegalArgumentException("scopeInfoList is empty or null");
    }
    paramContext = (ViewGroup)y.gt(this.mContext).inflate(y.h.app_brand_auth_dialog, null);
    setContentView(paramContext);
    paramString1 = (ImageView)paramContext.findViewById(y.g.app_icon_iv);
    com.tencent.mm.modelappbrand.a.b.JD().a(paramString1, this.fXS, a.JC(), f.eaL);
    ((TextView)paramContext.findViewById(y.g.app_name_tv)).setText(this.mContext.getString(y.j.login_auth_request_tips, new Object[] { this.mAppName }));
    this.fXT = ((AuthorizeItemListView)paramContext.findViewById(y.g.auth_content_list));
    this.hsq = new c.b(paramLinkedList);
    this.fXT.setAdapter(this.hsq);
    if (paramLinkedList.size() > 5)
    {
      this.fXT.Zn = paramLinkedList.size();
      this.fXV = ((LinearLayout)paramContext.findViewById(y.g.auth_scope_list_layout));
      paramString1 = (LinearLayout.LayoutParams)this.fXV.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(y.e.login_desc_list_height);
      this.fXV.setLayoutParams(paramString1);
    }
    ((Button)paramContext.findViewById(y.g.login_accept)).setOnClickListener(new c.1(this, paramLinkedList, parama, this));
    ((Button)paramContext.findViewById(y.g.login_reject)).setOnClickListener(new c.2(this, paramLinkedList, parama, this));
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new c.3(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c
 * JD-Core Version:    0.7.0.1
 */