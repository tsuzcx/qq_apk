package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.a.a.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.d;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b
{
  private Context context;
  public String fXS;
  AuthorizeItemListView fXT;
  private b.b fXU;
  private LinearLayout fXV;
  public String mAppName = "";
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(final LinkedList<bna> paramLinkedList, final b.a parama)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
      return false;
    }
    final i locali = new i(this.context);
    LinearLayout localLinearLayout = (LinearLayout)((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(b.c.authorize_dialog_view, null);
    Object localObject1 = (TextView)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.wechat_auth);
    if (!bk.bl(null)) {
      ((TextView)localObject1).setText(null);
    }
    localObject1 = (ImageView)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.app_icon_iv);
    Object localObject2 = a.decodeResource(ae.getResources(), b.d.default_avatar);
    localObject2 = d.a(ae.getResources(), (Bitmap)localObject2);
    ((android.support.v4.a.a.b)localObject2).cp();
    if (localObject1 != null) {
      com.tencent.mm.modelappbrand.a.b.JD().a((ImageView)localObject1, this.fXS, (Drawable)localObject2, f.eaL);
    }
    localObject1 = (TextView)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.app_name_tv);
    if (this.mAppName == null) {
      this.mAppName = "";
    }
    ((TextView)localObject1).setText(this.context.getString(b.e.login_auth_request_tips, new Object[] { this.mAppName }));
    this.fXT = ((AuthorizeItemListView)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.auth_content_list));
    this.fXU = new b.b(this, paramLinkedList);
    this.fXT.setAdapter(this.fXU);
    if (paramLinkedList.size() > 5)
    {
      this.fXT.Zn = paramLinkedList.size();
      this.fXV = ((LinearLayout)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.auth_scope_list_layout));
      localObject1 = (LinearLayout.LayoutParams)this.fXV.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).height = this.context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.appbrand.wxawidget.b.a.login_desc_list_height);
      this.fXV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    ((Button)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.login_accept)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramLinkedList.size())
        {
          if ((((bna)paramLinkedList.get(i)).tGf == 2) || (((bna)paramLinkedList.get(i)).tGf == 3)) {
            paramAnonymousView.add(((bna)paramLinkedList.get(i)).sEi);
          }
          i += 1;
        }
        y.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("key_scope", paramAnonymousView);
        parama.e(1, localBundle);
        locali.dismiss();
      }
    });
    ((Button)localLinearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.login_reject)).setOnClickListener(new b.2(this, paramLinkedList, parama, locali));
    locali.setCanceledOnTouchOutside(false);
    locali.setOnDismissListener(new b.3(this));
    locali.setOnCancelListener(new b.4(this, parama));
    locali.setContentView(localLinearLayout);
    try
    {
      locali.show();
      return true;
    }
    catch (Exception paramLinkedList)
    {
      y.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[] { paramLinkedList.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b
 * JD-Core Version:    0.7.0.1
 */