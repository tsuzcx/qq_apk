package com.tencent.mm.plugin.finder.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.w.a.a.a.c;
import com.tencent.mm.w.a.a.a.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/tools/DebugDialog;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "createDialogInfo", "", "context", "Landroid/content/Context;", "txt", "showStreamInfo", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "dataList", "", "title", "onClickOk", "Landroid/content/DialogInterface$OnClickListener;", "onClickCancel", "onItemClick", "RvAdapter", "ViewHolder", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a FNQ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(330459);
    FNQ = new a();
    TAG = "MicroMsg.DebugDialog";
    AppMethodBeat.o(330459);
  }
  
  private static final void a(String paramString, Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(330435);
    s.u(paramString, "$txt");
    s.u(paramContext, "$context");
    Log.i(TAG, "onClick1");
    ClipboardHelper.setText((CharSequence)paramString);
    Toast.makeText(paramContext, (CharSequence)"copy done", 0).show();
    AppMethodBeat.o(330435);
  }
  
  public static void aF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(330415);
    s.u(paramContext, "context");
    s.u(paramString, "txt");
    TextView localTextView = new TextView(paramContext);
    localTextView.setText((CharSequence)paramString);
    localTextView.setGravity(3);
    localTextView.setTextSize(1, 13.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(paramContext.getResources().getColor(com.tencent.mm.w.a.a.a.b.black_color));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(a.c.SmallestPadding);
    localTextView.setPadding(i, i, i, i);
    localTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    a..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new a..ExternalSyntheticLambda0(paramString, paramContext);
    a..ExternalSyntheticLambda3 localExternalSyntheticLambda3 = a..ExternalSyntheticLambda3.INSTANCE;
    Log.i(TAG, s.X("dialog msg ", paramString));
    k.a(paramContext, "视频号测试", (View)localTextView, "copy", "cancel", localExternalSyntheticLambda0, localExternalSyntheticLambda3);
    AppMethodBeat.o(330415);
  }
  
  private static final void v(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(330443);
    Log.i(TAG, "onClickCancel");
    AppMethodBeat.o(330443);
  }
  
  private static final void w(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(330449);
    Log.i(TAG, "onClickOk");
    AppMethodBeat.o(330449);
  }
  
  private static final void x(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(330452);
    Log.i(TAG, "onClickOk");
    AppMethodBeat.o(330452);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/tools/DebugDialog$RvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/tools/DebugDialog$ViewHolder;", "dataList", "", "", "onItemClick", "Landroid/content/DialogInterface$OnClickListener;", "(Ljava/util/List;Landroid/content/DialogInterface$OnClickListener;)V", "getDataList", "()Ljava/util/List;", "getOnItemClick", "()Landroid/content/DialogInterface$OnClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.a<a.b>
  {
    private final DialogInterface.OnClickListener FNR;
    private final List<String> dataList;
    
    public a(List<String> paramList, DialogInterface.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(330410);
      this.dataList = paramList;
      this.FNR = paramOnClickListener;
      AppMethodBeat.o(330410);
    }
    
    private static final void a(a parama, a.b paramb, int paramInt, View paramView)
    {
      AppMethodBeat.i(330416);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/tools/DebugDialog$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramb, "$holder");
      if (parama.FNR == null)
      {
        parama = paramb.descTv;
        if (parama == null)
        {
          parama = (CharSequence)"";
          ClipboardHelper.setText(parama);
          Toast.makeText(paramb.caK.getContext(), (CharSequence)"copy done", 0).show();
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/tools/DebugDialog$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(330416);
        return;
        paramView = parama.getText();
        parama = paramView;
        if (paramView != null) {
          break;
        }
        parama = (CharSequence)"";
        break;
        parama.FNR.onClick(null, paramInt);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(330430);
      int i = this.dataList.size();
      AppMethodBeat.o(330430);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/tools/DebugDialog$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    TextView descTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(330404);
      this.descTv = ((TextView)paramView.findViewById(a.e.stream_info_tv));
      AppMethodBeat.o(330404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.tools.a
 * JD-Core Version:    0.7.0.1
 */