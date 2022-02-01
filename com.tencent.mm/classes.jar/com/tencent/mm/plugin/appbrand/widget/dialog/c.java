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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends b
{
  private final String kBD;
  private final String mAppName;
  private Context mContext;
  private AuthorizeItemListView ngf;
  private LinearLayout ngh;
  private b ngn;
  
  public c(final Context paramContext, List<c> paramList, String paramString1, String paramString2, final a parama)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(220902);
    this.mContext = paramContext;
    this.mAppName = bu.nullAsNil(paramString1);
    this.kBD = paramString2;
    if ((paramList instanceof ArrayList)) {}
    for (paramContext = (ArrayList)paramList; (paramContext == null) || (paramContext.size() <= 0); paramContext = new ArrayList(paramList))
    {
      paramContext = new IllegalArgumentException("scopeInfoList is empty or null");
      AppMethodBeat.o(220902);
      throw paramContext;
    }
    paramList = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131492972, null);
    setContentView(paramList);
    paramString1 = (ImageView)paramList.findViewById(2131296853);
    com.tencent.mm.modelappbrand.a.b.aEl().a(paramString1, this.kBD, 2131233241, g.hOv);
    ((TextView)paramList.findViewById(2131296866)).setText(this.mContext.getString(2131760748, new Object[] { this.mAppName }));
    this.ngf = ((AuthorizeItemListView)paramList.findViewById(2131296973));
    this.ngn = new b(paramContext);
    this.ngf.setAdapter(this.ngn);
    if (paramContext.size() > 5)
    {
      this.ngf.ajO = paramContext.size();
      this.ngh = ((LinearLayout)paramList.findViewById(2131296983));
      paramString1 = (LinearLayout.LayoutParams)this.ngh.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(2131166486);
      this.ngh.setLayoutParams(paramString1);
    }
    ((Button)paramList.findViewById(2131301557)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147732);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          if ((((c.c)paramContext.get(i)).state == 2) || (((c.c)paramContext.get(i)).state == 3)) {
            paramAnonymousView.add(((c.c)paramContext.get(i)).scope);
          }
          i += 1;
        }
        ae.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        parama.a(1, paramAnonymousView);
        jdField_this.dismiss();
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(147732);
      }
    });
    ((Button)paramList.findViewById(2131301580)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147733);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          if ((((c.c)paramContext.get(i)).state == 2) || (((c.c)paramContext.get(i)).state == 3)) {
            paramAnonymousView.add(((c.c)paramContext.get(i)).scope);
          }
          i += 1;
        }
        ae.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
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
        ae.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        parama.a(3, null);
        AppMethodBeat.o(147734);
      }
    });
    AppMethodBeat.o(220902);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, ArrayList<String> paramArrayList);
  }
  
  static final class b
    extends BaseAdapter
  {
    private final ArrayList<c.c> ngt;
    
    b(ArrayList<c.c> paramArrayList)
    {
      this.ngt = paramArrayList;
    }
    
    private c.c wp(int paramInt)
    {
      AppMethodBeat.i(147737);
      c.c localc = (c.c)this.ngt.get(paramInt);
      AppMethodBeat.o(147737);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(147736);
      if (this.ngt == null)
      {
        AppMethodBeat.o(147736);
        return 0;
      }
      int i = this.ngt.size();
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
      if ((this.ngt == null) || (this.ngt.size() <= 0))
      {
        AppMethodBeat.o(147738);
        return null;
      }
      final c.c localc = wp(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131493120, null);
        paramView.ngx = ((ImageView)((View)localObject).findViewById(2131296682));
        paramView.ngr = ((TextView)((View)localObject).findViewById(2131296681));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localc.state != 1) {
          break label173;
        }
        paramViewGroup.ngx.setImageResource(2131232921);
      }
      for (;;)
      {
        paramViewGroup.ngr.setText(localc.desc);
        localObject = paramViewGroup.ngx;
        paramViewGroup.ngx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(147735);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (localc.state == 2)
            {
              this.ngv.setImageResource(2131232921);
              localc.state = 1;
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(147735);
              return;
              if (localc.state == 1)
              {
                this.ngv.setImageResource(2131232919);
                localc.state = 2;
              }
            }
          }
        });
        AppMethodBeat.o(147738);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label173:
        if (localc.state == 3) {
          paramViewGroup.ngx.setImageResource(2131232920);
        } else {
          paramViewGroup.ngx.setImageResource(2131232919);
        }
      }
    }
    
    static final class a
    {
      TextView ngr;
      ImageView ngx;
    }
  }
  
  public static final class c
  {
    public String desc;
    public String scope;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c
 * JD-Core Version:    0.7.0.1
 */