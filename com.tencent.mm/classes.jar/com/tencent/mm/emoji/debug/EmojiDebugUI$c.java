package com.tencent.mm.emoji.debug;

import a.a.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
public final class EmojiDebugUI$c<T>
  extends EmojiDebugUI.a
{
  final ac.a euS;
  private final List<String> euT;
  final List<T> euU;
  private final String title;
  
  public EmojiDebugUI$c(String paramString, ac.a parama, List<String> paramList, List<? extends T> paramList1)
  {
    super(paramString);
    AppMethodBeat.i(63120);
    this.title = parama;
    this.euS = paramList;
    this.euT = paramList1;
    this.euU = localObject;
    AppMethodBeat.o(63120);
  }
  
  public final String Ol()
  {
    return this.title;
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(63119);
    LinkedList localLinkedList = new LinkedList();
    int j = ((Collection)this.euT).size();
    int i = 0;
    while (i < j)
    {
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)this.euQ, "", this.euT, j.m((Iterable)j.e((Collection)this.euT)), "", (h.d)new EmojiDebugUI.c.a(this));
    AppMethodBeat.o(63119);
  }
  
  public final String value()
  {
    AppMethodBeat.i(63118);
    int i = this.euU.indexOf(EmojiDebugUI.a(this.euS, this.euU.get(0)));
    if ((i >= 0) && (i < this.euT.size()))
    {
      str = (String)this.euT.get(i);
      AppMethodBeat.o(63118);
      return str;
    }
    String str = (String)this.euT.get(0);
    AppMethodBeat.o(63118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI.c
 * JD-Core Version:    0.7.0.1
 */