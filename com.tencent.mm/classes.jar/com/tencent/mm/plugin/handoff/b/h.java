package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/HandOffURLParser;", "Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "()V", "newHandOff", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "api-handoff_release"})
public final class h
  extends f<HandOffURL>
{
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238088);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(238088);
          return;
          if (paramString.equals("handofftype"))
          {
            int i = e(paramXmlPullParser);
            ((HandOffURL)dYo()).setHandOffType(i);
            AppMethodBeat.o(238088);
            return;
            if (paramString.equals("icon"))
            {
              paramString = d(paramXmlPullParser);
              ((HandOffURL)dYo()).setIcon(paramString);
            }
          }
        }
      } while (!paramString.equals("title"));
      paramString = d(paramXmlPullParser);
      ((HandOffURL)dYo()).setTitle(paramString);
      AppMethodBeat.o(238088);
      return;
    } while (!paramString.equals("url"));
    paramString = d(paramXmlPullParser);
    ((HandOffURL)dYo()).setUrl(paramString);
    AppMethodBeat.o(238088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.h
 * JD-Core Version:    0.7.0.1
 */