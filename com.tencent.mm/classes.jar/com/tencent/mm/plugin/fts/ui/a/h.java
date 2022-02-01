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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends a
{
  CharSequence tBj;
  private b tBk;
  a tBl;
  
  public h(int paramInt)
  {
    super(10, paramInt);
    AppMethodBeat.i(112077);
    this.tBk = new b((byte)0);
    this.tBl = new a((byte)0);
    AppMethodBeat.o(112077);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112078);
    parama = new SpannableStringBuilder();
    paramVarArgs = this.tun.tuN;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      SpannableString localSpannableString = new SpannableString(localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.tya), 0, localObject.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.tBj = TextUtils.concat(new CharSequence[] { paramContext.getString(2131763011), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131763010) });
    AppMethodBeat.o(112078);
  }
  
  public final a.b agC()
  {
    return this.tBk;
  }
  
  final class a
    extends a.a
  {
    TextView iCV;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494195, paramViewGroup, false);
      paramViewGroup = (h.a)h.this.tBl;
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112074);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112075);
      paramContext = (h.a)parama;
      n.a(h.this.tBj, paramContext.iCV);
      AppMethodBeat.o(112075);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112076);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("query_phrase_list", bt.U(h.this.tun.tuN));
      paramVarArgs.putExtra("go_to_chatroom_direct", true);
      paramVarArgs.putExtra("scene_from", 3);
      d.f(paramContext, ".ui.transmit.MMCreateChatroomUI", paramVarArgs);
      AppMethodBeat.o(112076);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.h
 * JD-Core Version:    0.7.0.1
 */