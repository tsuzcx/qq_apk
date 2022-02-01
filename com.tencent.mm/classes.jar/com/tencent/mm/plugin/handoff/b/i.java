package com.tencent.mm.plugin.handoff.b;

import com.tencent.mm.plugin.handoff.model.HandOff;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "", "parseHandOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface i
{
  public abstract HandOff h(XmlPullParser paramXmlPullParser);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.i
 * JD-Core Version:    0.7.0.1
 */