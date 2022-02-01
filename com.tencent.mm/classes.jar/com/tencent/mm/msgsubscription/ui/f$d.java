package com.tencent.mm.msgsubscription.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.msgsubscription.a.a;
import com.tencent.mm.msgsubscription.a.d;
import com.tencent.mm.msgsubscription.a.e;
import com.tencent.mm.msgsubscription.a.f;
import com.tencent.mm.msgsubscription.a.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onForceNotifyItemCheckChanged", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$ForceNotifyHolder;", "causeByUserAction", "", "onForceNotifySwitchChanged", "pos", "forceNotify", "userAction", "item", "vibrateAndShakeBell", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "ForceNotifyHolder", "NormalHolder", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$d
  extends RecyclerView.a<RecyclerView.v>
{
  public static final f.d.a pmc;
  private List<? extends f.c> bMQ;
  private final f pmd;
  private final List<f.c> pme;
  
  static
  {
    AppMethodBeat.i(236628);
    pmc = new f.d.a((byte)0);
    AppMethodBeat.o(236628);
  }
  
  public f$d(List<? extends f.c> paramList, f paramf)
  {
    AppMethodBeat.i(149752);
    this.bMQ = paramList;
    this.pmd = paramf;
    this.pme = ((List)new ArrayList());
    paramList = this.pme;
    Object localObject1 = (Iterable)this.bMQ;
    paramf = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((f.c)localObject2).plZ) {
        paramf.add(localObject2);
      }
    }
    paramList.addAll((Collection)paramf);
    f.a(this.pmd, this.pme.size());
    AppMethodBeat.o(149752);
  }
  
  private final void a(int paramInt, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(236606);
    ((f.c)this.bMQ.get(paramInt)).plZ = paramb.checkBox.isChecked();
    f.c localc = (f.c)this.bMQ.get(paramInt);
    if (localc.plZ) {
      this.pme.add(localc);
    }
    for (;;)
    {
      f.a(this.pmd, this.pme.size());
      AppMethodBeat.o(236606);
      return;
      this.pme.remove(localc);
      if ((paramBoolean) && ((localc instanceof f.e)))
      {
        ((f.e)localc).phv = false;
        a(paramInt, ((f.e)localc).phv, true, paramb, (f.c)this.bMQ.get(paramInt));
      }
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, b paramb, f.c paramc)
  {
    AppMethodBeat.i(236600);
    Object localObject = f.i(this.pmd);
    if (localObject != null) {
      ((f.g)localObject).a(f.g.a.a.pmn, paramBoolean1, paramc, paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramc = paramb.pmh;
      localObject = MMApplicationContext.getContext().getSystemService("vibrator");
      if (localObject == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
        AppMethodBeat.o(236600);
        throw paramb;
      }
      localObject = (Vibrator)localObject;
      if ((Build.VERSION.SDK_INT < 26) || (!((Vibrator)localObject).hasAmplitudeControl())) {
        break label702;
      }
      ((Vibrator)localObject).vibrate(VibrationEffect.createWaveform(new long[] { 50L, 5L, 50L, 10L }, new int[] { 0, 128, 0, 255 }, -1));
      localObject = (List)new ArrayList();
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramc, "rotation", new float[] { 0.0F, 15.0F });
      s.s(localObjectAnimator, "ofFloat(view, \"rotation\", 0F, 15F)");
      localObjectAnimator.setDuration(150L);
      paramc.setPivotX(paramc.getMeasuredWidth() / 2.0F);
      paramc.setPivotY(0.0F);
      ((List)localObject).add(localObjectAnimator);
      localObjectAnimator = ObjectAnimator.ofFloat(paramc, "rotation", new float[] { 15.0F, -15.0F });
      s.s(localObjectAnimator, "ofFloat(view, \"rotation\", 15F, -15F)");
      localObjectAnimator.setDuration(150L);
      paramc.setPivotX(paramc.getMeasuredWidth() / 2.0F);
      paramc.setPivotY(0.0F);
      ((List)localObject).add(localObjectAnimator);
      localObjectAnimator = ObjectAnimator.ofFloat(paramc, "rotation", new float[] { -15.0F, 5.0F });
      s.s(localObjectAnimator, "ofFloat(view, \"rotation\", -15F, 5F)");
      localObjectAnimator.setDuration(130L);
      paramc.setPivotX(paramc.getMeasuredWidth() / 2.0F);
      paramc.setPivotY(0.0F);
      ((List)localObject).add(localObjectAnimator);
      localObjectAnimator = ObjectAnimator.ofFloat(paramc, "rotation", new float[] { 5.0F, -5.0F });
      s.s(localObjectAnimator, "ofFloat(view, \"rotation\", 5F, -5F)");
      localObjectAnimator.setDuration(120L);
      paramc.setPivotX(paramc.getMeasuredWidth() / 2.0F);
      paramc.setPivotY(0.0F);
      ((List)localObject).add(localObjectAnimator);
      localObjectAnimator = ObjectAnimator.ofFloat(paramc, "rotation", new float[] { -5.0F, 0.0F });
      s.s(localObjectAnimator, "ofFloat(view, \"rotation\", -5F, 0F)");
      localObjectAnimator.setDuration(120L);
      paramc.setPivotX(paramc.getMeasuredWidth() / 2.0F);
      paramc.setPivotY(0.0F);
      ((List)localObject).add(localObjectAnimator);
      paramc = new AnimatorSet();
      paramc.playSequentially(p.p((Iterable)localObject));
      paramc.start();
      if (!paramb.checkBox.isChecked())
      {
        paramb.checkBox.setChecked(true);
        a(paramInt, paramb, false);
      }
    }
    label604:
    int i;
    if (paramBoolean1)
    {
      paramInt = paramb.pmh.getContext().getResources().getColor(a.a.subscribe_msg_dialog_force_notify_bell_yellow);
      if (!paramBoolean1) {
        break label759;
      }
      i = a.f.icons_outlined_bellring_shake;
      label613:
      paramc = bb.e(paramb.caK.getContext().getResources().getDrawable(i), paramInt);
      paramb.pmh.setImageDrawable(paramc);
      paramb.pmh.setIconColor(paramInt);
      paramc = h.ahAA;
      paramb = new f.d..ExternalSyntheticLambda3(paramb, paramBoolean1);
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label767;
      }
    }
    label702:
    label759:
    label767:
    for (long l = 300L;; l = 0L)
    {
      paramc.o(paramb, l);
      AppMethodBeat.o(236600);
      return;
      ((Vibrator)localObject).vibrate(new long[] { 50L, 5L, 50L, 10L }, -1);
      break;
      paramInt = paramb.pmh.getContext().getResources().getColor(a.a.BW_0_Alpha_0_5);
      break label604;
      i = a.f.icons_outlined_bellring_close;
      break label613;
    }
  }
  
  private static final void a(RecyclerView.v paramv, d paramd, int paramInt, View paramView)
  {
    AppMethodBeat.i(236617);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramv);
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "$holder");
    s.u(paramd, "this$0");
    paramView = ((c)paramv).checkBox;
    boolean bool;
    if (!((c)paramv).checkBox.isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      ((f.c)paramd.bMQ.get(paramInt)).plZ = ((c)paramv).checkBox.isChecked();
      if (!((f.c)paramd.bMQ.get(paramInt)).plZ) {
        break label230;
      }
      paramd.pme.add(paramd.bMQ.get(paramInt));
    }
    for (;;)
    {
      f.a(paramd.pmd, paramd.pme.size());
      a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236617);
      return;
      bool = false;
      break;
      label230:
      paramd.pme.remove(paramd.bMQ.get(paramInt));
    }
  }
  
  private static final void a(f.c paramc, d paramd, int paramInt, RecyclerView.v paramv, View paramView)
  {
    AppMethodBeat.i(236624);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramv);
    localb.cH(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "$item");
    s.u(paramd, "this$0");
    s.u(paramv, "$holder");
    paramView = (f.e)paramc;
    if (!((f.e)paramc).phv) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.phv = bool;
      paramd.a(paramInt, ((f.e)paramc).phv, true, (b)paramv, (f.c)paramd.bMQ.get(paramInt));
      a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236624);
      return;
    }
  }
  
  private static final void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(236610);
    s.u(paramb, "$holder");
    TextView localTextView = paramb.pmi;
    Resources localResources = paramb.caK.getResources();
    if (paramBoolean)
    {
      i = a.g.subscribe_msg_dialog_force_notify_button_state_desc_had_add;
      localTextView.setText(localResources.getText(i));
      localTextView = paramb.pmi;
      paramb = paramb.caK.getResources();
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (int i = a.a.normal_text;; i = a.a.desc_text_color)
    {
      localTextView.setTextColor(paramb.getColor(i));
      AppMethodBeat.o(236610);
      return;
      i = a.g.subscribe_msg_dialog_force_notify_button_state_desc_add;
      break;
    }
  }
  
  private static final void b(RecyclerView.v paramv, d paramd, int paramInt, View paramView)
  {
    AppMethodBeat.i(236620);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramv);
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "$holder");
    s.u(paramd, "this$0");
    paramView = ((b)paramv).checkBox;
    if (!((b)paramv).checkBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      paramd.a(paramInt, (b)paramv, true);
      a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236620);
      return;
    }
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(236654);
    s.u(paramViewGroup, "parent");
    if (paramInt == 2)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.subscribe_msg_force_notify_item_layout, null);
      s.s(paramViewGroup, "from(parent.context).inf…notify_item_layout, null)");
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
      AppMethodBeat.o(236654);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.subscribe_msg_item_layout, null);
    s.s(paramViewGroup, "from(parent.context).inf…be_msg_item_layout, null)");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(236654);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(236677);
    s.u(paramv, "holder");
    if ((paramv instanceof c))
    {
      ((c)paramv).checkBox.setChecked(((f.c)this.bMQ.get(paramInt)).plZ);
      ((c)paramv).pmf.setText((CharSequence)((f.c)this.bMQ.get(paramInt)).title);
      paramv.caK.setOnClickListener(new f.d..ExternalSyntheticLambda1(paramv, this, paramInt));
      AppMethodBeat.o(236677);
      return;
    }
    if ((paramv instanceof b))
    {
      ((b)paramv).checkBox.setChecked(((f.c)this.bMQ.get(paramInt)).plZ);
      ((b)paramv).pmf.setText((CharSequence)((f.c)this.bMQ.get(paramInt)).title);
      paramv.caK.setOnClickListener(new f.d..ExternalSyntheticLambda0(paramv, this, paramInt));
      f.c localc = (f.c)this.bMQ.get(paramInt);
      if ((localc instanceof f.e))
      {
        a(paramInt, ((f.e)localc).phv, false, (b)paramv, (f.c)this.bMQ.get(paramInt));
        ((b)paramv).pmg.setOnClickListener(new f.d..ExternalSyntheticLambda2(localc, this, paramInt, paramv));
      }
    }
    AppMethodBeat.o(236677);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(149750);
    int i = this.bMQ.size();
    AppMethodBeat.o(149750);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(236666);
    if ((this.bMQ.get(paramInt) instanceof f.e))
    {
      AppMethodBeat.o(236666);
      return 2;
    }
    AppMethodBeat.o(236666);
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$ForceNotifyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "forceNotifyClickArea", "getForceNotifyClickArea", "()Landroid/view/View;", "setForceNotifyClickArea", "forceNotifyIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getForceNotifyIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setForceNotifyIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "forceNotifyStateDesc", "getForceNotifyStateDesc", "setForceNotifyStateDesc", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView pmf;
    View pmg;
    WeImageView pmh;
    TextView pmi;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(236601);
      paramView = this.caK.findViewById(a.d.checkbox);
      s.s(paramView, "itemView.findViewById(R.id.checkbox)");
      this.checkBox = ((CheckBox)paramView);
      paramView = this.caK.findViewById(a.d.desc);
      s.s(paramView, "itemView.findViewById(R.id.desc)");
      this.pmf = ((TextView)paramView);
      paramView = this.caK.findViewById(a.d.force_notify_layout);
      s.s(paramView, "itemView.findViewById(R.id.force_notify_layout)");
      this.pmg = paramView;
      paramView = this.caK.findViewById(a.d.force_notify_iv);
      s.s(paramView, "itemView.findViewById(R.id.force_notify_iv)");
      this.pmh = ((WeImageView)paramView);
      paramView = this.caK.findViewById(a.d.force_notify_desc_tv);
      s.s(paramView, "itemView.findViewById(R.id.force_notify_desc_tv)");
      this.pmi = ((TextView)paramView);
      AppMethodBeat.o(236601);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$NormalHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView pmf;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(236595);
      paramView = this.caK.findViewById(a.d.checkbox);
      s.s(paramView, "itemView.findViewById(R.id.checkbox)");
      this.checkBox = ((CheckBox)paramView);
      paramView = this.caK.findViewById(a.d.desc);
      s.s(paramView, "itemView.findViewById(R.id.desc)");
      this.pmf = ((TextView)paramView);
      AppMethodBeat.o(236595);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.f.d
 * JD-Core Version:    0.7.0.1
 */