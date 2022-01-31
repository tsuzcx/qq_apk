package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.sdk.platformtools.bk;

final class h$b
  extends a.b
{
  private h$b(h paramh)
  {
    super(paramh);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_create_chatroom_item, paramViewGroup, false);
    paramViewGroup = (h.a)this.kDi.kDh;
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(n.d.desc_tv));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (h.a)parama;
    m.a(this.kDi.kDf, paramContext.eXP);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("query_phrase_list", bk.G(this.kDi.kwi.kwI));
    paramVarArgs.putExtra("go_to_chatroom_direct", true);
    paramVarArgs.putExtra("scene_from", 3);
    d.e(paramContext, ".ui.transmit.MMCreateChatroomUI", paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.h.b
 * JD-Core Version:    0.7.0.1
 */