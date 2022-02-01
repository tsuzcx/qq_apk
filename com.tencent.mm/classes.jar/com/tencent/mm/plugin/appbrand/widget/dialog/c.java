package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.a.b;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends b
{
  private final String mAppName;
  private Context mContext;
  private final String oBv;
  private b rrU;
  private AuthorizeItemListView rrp;
  private LinearLayout rrr;
  
  public c(final Context paramContext, List<c> paramList, String paramString1, String paramString2, final a parama)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(251609);
    this.mContext = paramContext;
    this.mAppName = Util.nullAsNil(paramString1);
    this.oBv = paramString2;
    if ((paramList instanceof ArrayList)) {}
    for (paramContext = (ArrayList)paramList; (paramContext == null) || (paramContext.size() <= 0); paramContext = new ArrayList(paramList))
    {
      paramContext = new IllegalArgumentException("scopeInfoList is empty or null");
      AppMethodBeat.o(251609);
      throw paramContext;
    }
    paramList = (ViewGroup)LayoutInflater.from(this.mContext).inflate(a.e.app_brand_auth_dialog, null);
    setContentView(paramList);
    paramString1 = (ImageView)paramList.findViewById(a.d.app_icon_iv);
    com.tencent.mm.modelappbrand.a.b.bhh().a(paramString1, this.oBv, a.c.miniprogram_default_avatar, g.lzF);
    ((TextView)paramList.findViewById(a.d.app_name_tv)).setText(this.mContext.getString(a.g.login_auth_request_tips, new Object[] { this.mAppName }));
    this.rrp = ((AuthorizeItemListView)paramList.findViewById(a.d.auth_content_list));
    this.rrU = new b(paramContext);
    this.rrp.setAdapter(this.rrU);
    if (paramContext.size() > 5)
    {
      this.rrp.afI = paramContext.size();
      this.rrr = ((LinearLayout)paramList.findViewById(a.d.auth_scope_list_layout));
      paramString1 = (LinearLayout.LayoutParams)this.rrr.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(a.b.login_desc_list_height);
      this.rrr.setLayoutParams(paramString1);
    }
    ((Button)paramList.findViewById(a.d.login_accept)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147732);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          if ((((c.c)paramContext.get(i)).state == 2) || (((c.c)paramContext.get(i)).state == 3)) {
            paramAnonymousView.add(((c.c)paramContext.get(i)).scope);
          }
          i += 1;
        }
        Log.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        parama.a(1, paramAnonymousView);
        jdField_this.dismiss();
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(147732);
      }
    });
    ((Button)paramList.findViewById(a.d.login_reject)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147733);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          if ((((c.c)paramContext.get(i)).state == 2) || (((c.c)paramContext.get(i)).state == 3)) {
            paramAnonymousView.add(((c.c)paramContext.get(i)).scope);
          }
          i += 1;
        }
        Log.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        parama.a(2, paramAnonymousView);
        jdField_this.dismiss();
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(147733);
      }
    });
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(147734);
        Log.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        parama.a(3, null);
        AppMethodBeat.o(147734);
      }
    });
    AppMethodBeat.o(251609);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, ArrayList<String> paramArrayList);
  }
  
  static final class b
    extends BaseAdapter
  {
    private final ArrayList<c.c> rsd;
    
    b(ArrayList<c.c> paramArrayList)
    {
      this.rsd = paramArrayList;
    }
    
    private c.c DF(int paramInt)
    {
      AppMethodBeat.i(147737);
      c.c localc = (c.c)this.rsd.get(paramInt);
      AppMethodBeat.o(147737);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(147736);
      if (this.rsd == null)
      {
        AppMethodBeat.o(147736);
        return 0;
      }
      int i = this.rsd.size();
      AppMethodBeat.o(147736);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(147738);
      if ((this.rsd == null) || (this.rsd.size() <= 0))
      {
        AppMethodBeat.o(147738);
        return null;
      }
      final c.c localc = DF(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), a.e.authorize_scope_item, null);
        paramView.rsl = ((ImageView)((View)localObject).findViewById(a.d.app_auth_state));
        paramView.rrB = ((TextView)((View)localObject).findViewById(a.d.app_auth_desc));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localc.state != 1) {
          break label177;
        }
        paramViewGroup.rsl.setImageResource(a.c.login_auth_state_not_selected);
      }
      for (;;)
      {
        paramViewGroup.rrB.setText(localc.desc);
        localObject = paramViewGroup.rsl;
        paramViewGroup.rsl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(147735);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (localc.state == 2)
            {
              this.rsf.setImageResource(a.c.login_auth_state_not_selected);
              localc.state = 1;
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(147735);
              return;
              if (localc.state == 1)
              {
                this.rsf.setImageResource(a.c.login_auth_state_default_select);
                localc.state = 2;
              }
            }
          }
        });
        AppMethodBeat.o(147738);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localc.state == 3) {
          paramViewGroup.rsl.setImageResource(a.c.login_auth_state_must_select);
        } else {
          paramViewGroup.rsl.setImageResource(a.c.login_auth_state_default_select);
        }
      }
    }
    
    static final class a
    {
      TextView rrB;
      ImageView rsl;
    }
  }
  
  public static final class c
  {
    public String desc;
    public String scope;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c
 * JD-Core Version:    0.7.0.1
 */