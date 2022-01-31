package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.p;

public final class SelectedMemberChattingRecordUI$a
  extends p<bi>
{
  String ejr;
  String ekc;
  int ekd;
  int eke;
  private u ekf;
  Context mContext;
  
  public SelectedMemberChattingRecordUI$a(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, new bi());
    AppMethodBeat.i(104439);
    this.ekd = -1;
    this.eke = -1;
    this.mContext = paramContext;
    this.eke = paramInt;
    this.ejr = paramString1;
    this.ekc = paramString2;
    this.ekf = ((c)g.E(c.class)).YJ().oV(SelectedMemberChattingRecordUI.b(paramSelectedMemberChattingRecordUI));
    AppMethodBeat.o(104439);
  }
  
  private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
  {
    AppMethodBeat.i(104443);
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramTextView.getContext(), paramCharSequence));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(104443);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(104443);
    return false;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(104440);
    if ((this.ekd < 0) || (this.ekd > this.eke)) {
      this.ekd = (this.eke - 16);
    }
    if ((!bo.isNullOrNil(SelectedMemberChattingRecordUI.c(this.ekb))) && (r.nB(SelectedMemberChattingRecordUI.c(this.ekb))))
    {
      setCursor(((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().cL(this.ejr, this.eke - this.ekd));
      AppMethodBeat.o(104440);
      return;
    }
    if (!r.nB(SelectedMemberChattingRecordUI.c(this.ekb))) {
      setCursor(((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().L(this.ejr, this.ekc, this.eke - this.ekd));
    }
    AppMethodBeat.o(104440);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(104441);
    Ku();
    AppMethodBeat.o(104441);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104442);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.context).inflate(2130970132, null, false);
      paramView = new SelectedMemberChattingRecordUI.b((byte)0);
      paramView.egq = ((ImageView)paramViewGroup.findViewById(2131821210));
      paramView.egr = ((TextView)paramViewGroup.findViewById(2131823254));
      paramView.ekg = ((TextView)paramViewGroup.findViewById(2131822982));
      paramView.ekh = ((TextView)paramViewGroup.findViewById(2131823255));
      paramViewGroup.setTag(paramView);
    }
    bi localbi = (bi)getItem(paramInt);
    SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
    a.b.c(localb.egq, this.ekc);
    paramView = this.ekc;
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramView);
    if (!bo.isNullOrNil(((aq)localObject2).field_conRemark))
    {
      paramView = ((aq)localObject2).field_conRemark;
      if (!bo.isNullOrNil(paramView)) {
        break label342;
      }
      paramView = ((ad)localObject2).Oe();
    }
    label342:
    for (;;)
    {
      Object localObject1 = paramView;
      if (!a.je(((aq)localObject2).field_type))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YB().TM(((aq)localObject2).field_username);
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject1 = paramView;
          if (!bo.isNullOrNil(((bv)localObject2).field_conRemark)) {
            localObject1 = ((bv)localObject2).field_conRemark;
          }
        }
      }
      a((CharSequence)localObject1, localb.egr);
      paramView = this.ekc;
      a(SelectedMemberChattingRecordUI.a(ah.getContext(), localbi.getType(), localbi.field_content, paramView, localbi.field_isSend).trim(), localb.ekg);
      a(com.tencent.mm.pluginsdk.f.h.c(this.ekb, localbi.field_createTime, true), localb.ekh);
      AppMethodBeat.o(104442);
      return paramViewGroup;
      paramView = SelectedMemberChattingRecordUI.a(this.ekf, ((aq)localObject2).field_username);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.a
 * JD-Core Version:    0.7.0.1
 */