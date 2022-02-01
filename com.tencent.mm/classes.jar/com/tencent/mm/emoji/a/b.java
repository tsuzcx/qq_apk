package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "EmojiAnimItem", "EmojiAnimScreenEffect", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public final ArrayList<a> gUV;
  
  public b()
  {
    AppMethodBeat.i(199874);
    this.gUV = new ArrayList();
    AppMethodBeat.o(199874);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(199873);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        skip(paramXmlPullParser);
        AppMethodBeat.o(199873);
        return;
      } while (!paramString.equals("item"));
      paramString = new a();
      paramString.c(paramXmlPullParser);
      this.gUV.add(paramString);
      AppMethodBeat.o(199873);
      return;
    } while (!paramString.equals("emoji"));
    AppMethodBeat.o(199873);
  }
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(199872);
    p.h(paramXmlPullParser, "parser");
    this.gUV.clear();
    super.c(paramXmlPullParser);
    AppMethodBeat.o(199872);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "animFile", "", "getAnimFile", "()Ljava/lang/String;", "setAnimFile", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "screenEffect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "getScreenEffect", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "setScreenEffect", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;)V", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
  public static final class a
    extends a
  {
    public String gUW = "";
    b.b gUX;
    public String key = "";
    
    public final void a(String paramString, XmlPullParser paramXmlPullParser)
    {
      AppMethodBeat.i(199870);
      p.h(paramString, "tag");
      p.h(paramXmlPullParser, "parser");
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            skip(paramXmlPullParser);
            AppMethodBeat.o(199870);
            return;
          } while (!paramString.equals("animFile"));
          this.gUW = d(paramXmlPullParser);
          AppMethodBeat.o(199870);
          return;
        } while (!paramString.equals("key"));
        this.key = d(paramXmlPullParser);
        AppMethodBeat.o(199870);
        return;
      } while (!paramString.equals("screenEffect"));
      paramString = new b.b();
      paramString.c(paramXmlPullParser);
      this.gUX = paramString;
      AppMethodBeat.o(199870);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "delay", "", "getDelay", "()I", "setDelay", "(I)V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
  public static final class b
    extends a
  {
    public int delay;
    public String effectId = "";
    
    public final void a(String paramString, XmlPullParser paramXmlPullParser)
    {
      AppMethodBeat.i(199871);
      p.h(paramString, "tag");
      p.h(paramXmlPullParser, "parser");
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          skip(paramXmlPullParser);
          AppMethodBeat.o(199871);
          return;
        } while (!paramString.equals("effectId"));
        this.effectId = d(paramXmlPullParser);
        AppMethodBeat.o(199871);
        return;
      } while (!paramString.equals("delay"));
      this.delay = e(paramXmlPullParser);
      AppMethodBeat.o(199871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */