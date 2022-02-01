package com.tencent.mm.plugin.fts.ui.a;

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
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends a
{
  CharSequence xdb;
  private b xdc;
  a xdd;
  
  public h(int paramInt)
  {
    super(10, paramInt);
    AppMethodBeat.i(112077);
    this.xdc = new b((byte)0);
    this.xdd = new a((byte)0);
    AppMethodBeat.o(112077);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112078);
    parama = new SpannableStringBuilder();
    paramVarArgs = this.wWd.wWD;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      SpannableString localSpannableString = new SpannableString(localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.wZQ), 0, localObject.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.xdb = TextUtils.concat(new CharSequence[] { paramContext.getString(2131765148), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131765147) });
    AppMethodBeat.o(112078);
  }
  
  public final a.b axc()
  {
    return this.xdc;
  }
  
  final class a
    extends a.a
  {
    TextView jBR;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494748, paramViewGroup, false);
      paramViewGroup = (h.a)h.this.xdd;
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112074);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112075);
      paramContext = (h.a)parama;
      n.a(h.this.xdb, paramContext.jBR);
      AppMethodBeat.o(112075);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(235399);
      paramView = new Intent();
      paramView.putExtra("query_phrase_list", Util.stringsToList(h.this.wWd.wWD));
      paramView.putExtra("go_to_chatroom_direct", true);
      paramView.putExtra("scene_from", 3);
      c.f(paramContext, ".ui.transmit.MMCreateChatroomUI", paramView);
      AppMethodBeat.o(235399);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.h
 * JD-Core Version:    0.7.0.1
 */