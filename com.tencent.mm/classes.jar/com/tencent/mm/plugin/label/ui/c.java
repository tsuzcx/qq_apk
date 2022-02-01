package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "headerAddViewHolder", "Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewHolder;", "headerAddViewItem", "Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewItem;", "onAddItemClickListener", "Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$OnAddItemClickListener;", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "setAddListener", "HeaderAddViewHolder", "HeaderAddViewItem", "OnAddItemClickListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  c JWR;
  private final b JWS;
  final a JWT;
  
  public c(int paramInt)
  {
    super(1, paramInt);
    AppMethodBeat.i(268751);
    this.JWS = new b();
    this.JWT = new a();
    AppMethodBeat.o(268751);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bVv()
  {
    return (a.b)this.JWS;
  }
  
  public final a.a bVw()
  {
    return (a.a)this.JWT;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem;)V", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    public LinearLayout lPl;
    
    public a()
    {
      super();
      AppMethodBeat.i(268687);
      AppMethodBeat.o(268687);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "setHolderView", "Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewHolder;", "Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem;", "view", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(268701);
      AppMethodBeat.o(268701);
    }
    
    private static final void a(c paramc, View paramView)
    {
      AppMethodBeat.i(268707);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      paramView = c.a(paramc);
      paramc = paramView;
      if (paramView == null)
      {
        s.bIx("onAddItemClickListener");
        paramc = null;
      }
      paramc.fTj();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/label/ui/HeaderAddDataItem$HeaderAddViewItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(268707);
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(268715);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(R.i.git, paramViewGroup, false);
      c.a locala = (c.a)this.JWU.JWT;
      s.checkNotNull(paramViewGroup);
      s.u(locala, "holder");
      s.u(paramViewGroup, "view");
      paramContext = paramViewGroup.findViewById(R.h.fLW);
      s.s(paramContext, "view.findViewById(R.id.label_add_member_layout)");
      paramContext = (LinearLayout)paramContext;
      s.u(paramContext, "<set-?>");
      locala.lPl = paramContext;
      paramContext = locala.lPl;
      if (paramContext != null) {}
      for (;;)
      {
        paramContext.setOnClickListener(new c.b..ExternalSyntheticLambda0(this.JWU));
        paramViewGroup.setTag(locala);
        AppMethodBeat.o(268715);
        return paramViewGroup;
        s.bIx("layout");
        paramContext = null;
      }
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$OnAddItemClickListener;", "", "onClicked", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void fTj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.c
 * JD-Core Version:    0.7.0.1
 */