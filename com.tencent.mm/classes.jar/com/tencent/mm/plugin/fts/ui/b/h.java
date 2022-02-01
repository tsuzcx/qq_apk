package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends a
{
  CharSequence BdX;
  private b HAP;
  a HAQ;
  
  public h(int paramInt)
  {
    super(10, paramInt);
    AppMethodBeat.i(112077);
    this.HAP = new b((byte)0);
    this.HAQ = new a((byte)0);
    AppMethodBeat.o(112077);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112078);
    parama = new SpannableStringBuilder();
    paramVarArgs = this.FWt.Htg;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      SpannableString localSpannableString = new SpannableString(localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.HwL), 0, localObject.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.BdX = TextUtils.concat(new CharSequence[] { paramContext.getString(p.g.select_create_desc_prefix), parama.subSequence(0, parama.length() - 1), paramContext.getString(p.g.select_create_desc_postfix) });
    AppMethodBeat.o(112078);
  }
  
  public final a.b aXA()
  {
    return this.HAP;
  }
  
  final class a
    extends a.a
  {
    TextView plr;
    
    private a()
    {
      super();
    }
  }
  
  final class b
    extends a.b
  {
    private b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112074);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_create_chatroom_item, paramViewGroup, false);
      paramViewGroup = (h.a)h.this.HAQ;
      paramViewGroup.plr = ((TextView)paramContext.findViewById(p.d.desc_tv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112074);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112075);
      paramContext = (h.a)parama;
      o.a(h.this.BdX, paramContext.plr);
      AppMethodBeat.o(112075);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(265727);
      paramView = new Intent();
      paramView.putExtra("query_phrase_list", Util.stringsToList(h.this.FWt.Htg));
      paramView.putExtra("go_to_chatroom_direct", true);
      paramView.putExtra("scene_from", 3);
      c.g(paramContext, ".ui.transmit.MMCreateChatroomUI", paramView);
      AppMethodBeat.o(265727);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.h
 * JD-Core Version:    0.7.0.1
 */