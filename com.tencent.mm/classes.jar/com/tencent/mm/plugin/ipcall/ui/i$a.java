package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;
import junit.framework.Assert;

public final class i$a
  extends BaseAdapter
{
  List<Integer> cvc;
  private Context mContext;
  View.OnClickListener yyO;
  
  public i$a(Context paramContext)
  {
    AppMethodBeat.i(25964);
    this.cvc = null;
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mContext = paramContext;
      AppMethodBeat.o(25964);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25965);
    if (this.cvc == null)
    {
      AppMethodBeat.o(25965);
      return 0;
    }
    int i = this.cvc.size();
    AppMethodBeat.o(25965);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(25966);
    if (this.cvc != null)
    {
      Object localObject = this.cvc.get(paramInt);
      AppMethodBeat.o(25966);
      return localObject;
    }
    AppMethodBeat.o(25966);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25967);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131495119, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.yyQ = ((RelativeLayout)paramView.findViewById(2131303060));
      paramViewGroup.yyR = ((TextView)paramView.findViewById(2131302786));
      paramViewGroup.yyS = ((ImageView)paramView.findViewById(2131302785));
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = getItem(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(25967);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.id = ((Integer)localObject).intValue();
    IPCallShareCouponCardUI.a(this.mContext, paramViewGroup.id, paramViewGroup.yyR, paramViewGroup.yyS);
    paramViewGroup.yyQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25963);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareDialog$IPCallShareItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (i.a.a(i.a.this) != null) {
          i.a.a(i.a.this).onClick(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareDialog$IPCallShareItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25963);
      }
    });
    AppMethodBeat.o(25967);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final class a
  {
    int id;
    RelativeLayout yyQ;
    TextView yyR;
    ImageView yyS;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i.a
 * JD-Core Version:    0.7.0.1
 */