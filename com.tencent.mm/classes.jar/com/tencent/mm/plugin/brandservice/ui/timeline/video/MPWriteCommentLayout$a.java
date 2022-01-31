package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;)V", "getController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "setController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;)V", "deleteStr", "", "getDeleteStr", "()Ljava/lang/CharSequence;", "setDeleteStr", "(Ljava/lang/CharSequence;)V", "clear", "", "getCount", "", "getItem", "position", "getItemId", "", "i", "getView", "Landroid/view/View;", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "initDeleteText", "textView", "Landroid/widget/TextView;", "onDeleteComment", "", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "update", "items", "", "clearUpdate", "", "updateCommentContentView", "info", "itemView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-brandservice_release"})
public final class MPWriteCommentLayout$a
  extends BaseAdapter
{
  static final String TAG = "MicroMsg.BizVideoMyCommentItemAdapter";
  public static final MPWriteCommentLayout.a.c khA;
  private static c khz;
  private final Context context;
  final LinkedList<kx> elu;
  private CharSequence khx;
  MPWriteCommentLayout khy;
  
  static
  {
    AppMethodBeat.i(152910);
    khA = new MPWriteCommentLayout.a.c((byte)0);
    TAG = "MicroMsg.BizVideoMyCommentItemAdapter";
    khz = new c.a().lI(2131689878).ahU().cx(120, 120).a((b)new f()).ahY();
    AppMethodBeat.o(152910);
  }
  
  public MPWriteCommentLayout$a(Context paramContext, LinkedList<kx> paramLinkedList, MPWriteCommentLayout paramMPWriteCommentLayout)
  {
    AppMethodBeat.i(152909);
    this.context = paramContext;
    this.elu = paramLinkedList;
    this.khy = paramMPWriteCommentLayout;
    AppMethodBeat.o(152909);
  }
  
  private kx sI(int paramInt)
  {
    AppMethodBeat.i(152905);
    kx localkx = (kx)a.a.j.w((List)this.elu, paramInt);
    AppMethodBeat.o(152905);
    return localkx;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(152904);
    this.elu.clear();
    notifyDataSetChanged();
    AppMethodBeat.o(152904);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(152907);
    int i = this.elu.size();
    AppMethodBeat.o(152907);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(152908);
    a.f.b.j.q(paramViewGroup, "viewGroup");
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2130970303, null, false);
      a.f.b.j.p(paramView, "convertView");
      paramViewGroup = new MPWriteCommentLayout.a.b(this, paramView);
      paramView.setTag(paramViewGroup);
      Object localObject1 = sI(paramInt);
      if (localObject1 != null)
      {
        a.f.b.j.q(localObject1, "info");
        com.tencent.mm.at.a.a.ahM().a(((kx)localObject1).kmm, paramViewGroup.gxs, khz);
        a locala = paramViewGroup.khF;
        a locala1 = paramViewGroup.khJ;
        a.f.b.j.q(locala1, "itemView");
        if (localObject1 != null)
        {
          Object localObject2 = locala.context;
          Object localObject3 = (CharSequence)((kx)localObject1).kVV;
          Object localObject4 = locala1.khB;
          a.f.b.j.p(localObject4, "itemView.nickName");
          localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject2, (CharSequence)localObject3, ((TextView)localObject4).getTextSize());
          localObject3 = locala1.khB;
          a.f.b.j.p(localObject3, "itemView.nickName");
          ((TextView)localObject3).setText((CharSequence)localObject2);
          localObject2 = locala.context;
          localObject3 = (CharSequence)((kx)localObject1).content;
          localObject4 = locala1.khD;
          a.f.b.j.p(localObject4, "itemView.desc");
          localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject2, (CharSequence)localObject3, ((NeatTextView)localObject4).getTextSize());
          locala1.khD.af((CharSequence)localObject2);
          localObject2 = locala1.khE;
          a.f.b.j.p(localObject2, "itemView.deleteTv");
          ((TextView)localObject2).setVisibility(0);
          localObject2 = locala1.khE;
          a.f.b.j.p(localObject2, "itemView.deleteTv");
          if (locala.khx == null)
          {
            int i = (int)(((TextView)localObject2).getTextSize() * 1.2D);
            localObject3 = locala.context.getString(2131296901);
            localObject4 = locala.context.getResources().getDrawable(2130837994);
            ((Drawable)localObject4).setBounds(0, 0, i, i);
            localObject4 = new com.tencent.mm.ui.widget.a((Drawable)localObject4);
            SpannableString localSpannableString = new SpannableString((CharSequence)"@");
            localSpannableString.setSpan(localObject4, 0, 1, 33);
            locala.khx = TextUtils.concat(new CharSequence[] { (CharSequence)localSpannableString, (CharSequence)" ", (CharSequence)localObject3 });
          }
          ((TextView)localObject2).setText(locala.khx);
          locala1.khE.setOnClickListener((View.OnClickListener)new MPWriteCommentLayout.a.d(locala, (kx)localObject1));
          localObject1 = locala1.khC;
          a.f.b.j.p(localObject1, "itemView.likeTv");
          ((TextView)localObject1).setVisibility(8);
        }
      }
      if (paramInt != getCount() - 1) {
        break label541;
      }
      paramViewGroup = paramViewGroup.khI;
      a.f.b.j.p(paramViewGroup, "holder.endlineLayout");
      paramViewGroup.setVisibility(0);
      this.khy.getAppMsgCommentList();
    }
    for (;;)
    {
      AppMethodBeat.o(152908);
      return paramView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.BizVideoMyCommentItemAdapter.BizCommentViewHolder");
        AppMethodBeat.o(152908);
        throw paramView;
      }
      paramViewGroup = (MPWriteCommentLayout.a.b)paramViewGroup;
      break;
      label541:
      paramViewGroup = paramViewGroup.khI;
      a.f.b.j.p(paramViewGroup, "holder.endlineLayout");
      paramViewGroup.setVisibility(8);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter;Landroid/view/View;)V", "deleteTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDeleteTv", "()Landroid/widget/TextView;", "setDeleteTv", "(Landroid/widget/TextView;)V", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeTv", "getLikeTv", "setLikeTv", "nickName", "getNickName", "setNickName", "plugin-brandservice_release"})
  public final class a
  {
    TextView khB;
    TextView khC;
    NeatTextView khD;
    TextView khE;
    
    public a()
    {
      AppMethodBeat.i(152900);
      this.khB = ((TextView)localObject.findViewById(2131826337));
      this.khC = ((TextView)localObject.findViewById(2131826339));
      this.khD = ((NeatTextView)localObject.findViewById(2131826340));
      this.khE = ((TextView)localObject.findViewById(2131826341));
      this.khB.setTextColor(MPWriteCommentLayout.a.a(MPWriteCommentLayout.a.this).getResources().getColor(2131690161));
      this.khD.setTextColor(MPWriteCommentLayout.a.a(MPWriteCommentLayout.a.this).getResources().getColor(2131689762));
      this.khE.setTextColor(MPWriteCommentLayout.a.a(MPWriteCommentLayout.a.this).getResources().getColor(2131690780));
      AppMethodBeat.o(152900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.a
 * JD-Core Version:    0.7.0.1
 */