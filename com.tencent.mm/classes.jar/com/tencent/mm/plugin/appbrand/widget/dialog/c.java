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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends b
{
  private final String lFU;
  private final String mAppName;
  private Context mContext;
  private AuthorizeItemListView opS;
  private LinearLayout opU;
  private b zZJ;
  
  public c(final Context paramContext, List<c> paramList, String paramString1, String paramString2, final a parama)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(230012);
    this.mContext = paramContext;
    this.mAppName = Util.nullAsNil(paramString1);
    this.lFU = paramString2;
    if ((paramList instanceof ArrayList)) {}
    for (paramContext = (ArrayList)paramList; (paramContext == null) || (paramContext.size() <= 0); paramContext = new ArrayList(paramList))
    {
      paramContext = new IllegalArgumentException("scopeInfoList is empty or null");
      AppMethodBeat.o(230012);
      throw paramContext;
    }
    paramList = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131493008, null);
    setContentView(paramList);
    paramString1 = (ImageView)paramList.findViewById(2131296945);
    com.tencent.mm.modelappbrand.a.b.aXY().a(paramString1, this.lFU, 2131233911, g.iJB);
    ((TextView)paramList.findViewById(2131296959)).setText(this.mContext.getString(2131762494, new Object[] { this.mAppName }));
    this.opS = ((AuthorizeItemListView)paramList.findViewById(2131297092));
    this.zZJ = new b(paramContext);
    this.opS.setAdapter(this.zZJ);
    if (paramContext.size() > 5)
    {
      this.opS.akb = paramContext.size();
      this.opU = ((LinearLayout)paramList.findViewById(2131297101));
      paramString1 = (LinearLayout.LayoutParams)this.opU.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(2131166595);
      this.opU.setLayoutParams(paramString1);
    }
    ((Button)paramList.findViewById(2131303775)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147732);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    ((Button)paramList.findViewById(2131303808)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147733);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    AppMethodBeat.o(230012);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, ArrayList<String> paramArrayList);
  }
  
  static final class b
    extends BaseAdapter
  {
    private final ArrayList<c.c> AgF;
    
    b(ArrayList<c.c> paramArrayList)
    {
      this.AgF = paramArrayList;
    }
    
    private c.c abO(int paramInt)
    {
      AppMethodBeat.i(147737);
      c.c localc = (c.c)this.AgF.get(paramInt);
      AppMethodBeat.o(147737);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(147736);
      if (this.AgF == null)
      {
        AppMethodBeat.o(147736);
        return 0;
      }
      int i = this.AgF.size();
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
      if ((this.AgF == null) || (this.AgF.size() <= 0))
      {
        AppMethodBeat.o(147738);
        return null;
      }
      final c.c localc = abO(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131493162, null);
        paramView.AsX = ((ImageView)((View)localObject).findViewById(2131296771));
        paramView.oqe = ((TextView)((View)localObject).findViewById(2131296770));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localc.state != 1) {
          break label173;
        }
        paramViewGroup.AsX.setImageResource(2131233564);
      }
      for (;;)
      {
        paramViewGroup.oqe.setText(localc.desc);
        localObject = paramViewGroup.AsX;
        paramViewGroup.AsX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(147735);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (localc.state == 2)
            {
              this.Alk.setImageResource(2131233564);
              localc.state = 1;
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(147735);
              return;
              if (localc.state == 1)
              {
                this.Alk.setImageResource(2131233562);
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
          paramViewGroup.AsX.setImageResource(2131233563);
        } else {
          paramViewGroup.AsX.setImageResource(2131233562);
        }
      }
    }
    
    static final class a
    {
      ImageView AsX;
      TextView oqe;
    }
  }
  
  public static final class c
  {
    public String desc;
    public String scope;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c
 * JD-Core Version:    0.7.0.1
 */