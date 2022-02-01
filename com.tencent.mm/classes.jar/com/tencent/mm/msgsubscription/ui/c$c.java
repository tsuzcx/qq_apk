package com.tencent.mm.msgsubscription.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "wxbiz-msgsubscription-sdk_release"})
public class c$c
{
  public final String lnb;
  boolean msA;
  public boolean msB;
  final ArrayList<o<String, String>> msC;
  final String title;
  
  public c$c(boolean paramBoolean, String paramString1, ArrayList<o<String, String>> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(149742);
    this.msB = paramBoolean;
    this.title = paramString1;
    this.msC = paramArrayList;
    this.lnb = paramString2;
    AppMethodBeat.o(149742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.c
 * JD-Core Version:    0.7.0.1
 */