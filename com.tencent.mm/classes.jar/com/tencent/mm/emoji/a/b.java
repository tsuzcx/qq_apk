package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.a;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "EmojiAnimItem", "EmojiAnimScreenEffect", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public final ArrayList<a> jFL;
  public int version;
  
  public b()
  {
    AppMethodBeat.i(224760);
    this.jFL = new ArrayList();
    AppMethodBeat.o(224760);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(224758);
    p.k(paramString, "tag");
    p.k(paramXmlPullParser, "parser");
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
          AppMethodBeat.o(224758);
          return;
        } while (!paramString.equals("emojiAnimVersion"));
        this.version = e(paramXmlPullParser);
        AppMethodBeat.o(224758);
        return;
      } while (!paramString.equals("item"));
      paramString = new a();
      paramString.c(paramXmlPullParser);
      this.jFL.add(paramString);
      AppMethodBeat.o(224758);
      return;
    } while (!paramString.equals("emoji"));
    AppMethodBeat.o(224758);
  }
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(224756);
    p.k(paramXmlPullParser, "parser");
    this.jFL.clear();
    super.c(paramXmlPullParser);
    AppMethodBeat.o(224756);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "animFile", "", "getAnimFile", "()Ljava/lang/String;", "setAnimFile", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "screenEffect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "getScreenEffect", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "setScreenEffect", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;)V", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
  public static final class a
    extends a
  {
    public String jFM = "";
    public b.b jFN;
    public String key = "";
    
    public final void a(String paramString, XmlPullParser paramXmlPullParser)
    {
      AppMethodBeat.i(236228);
      p.k(paramString, "tag");
      p.k(paramXmlPullParser, "parser");
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
            AppMethodBeat.o(236228);
            return;
          } while (!paramString.equals("animFile"));
          this.jFM = d(paramXmlPullParser);
          AppMethodBeat.o(236228);
          return;
        } while (!paramString.equals("key"));
        this.key = d(paramXmlPullParser);
        AppMethodBeat.o(236228);
        return;
      } while (!paramString.equals("screenEffect"));
      paramString = new b.b();
      paramString.c(paramXmlPullParser);
      this.jFN = paramString;
      AppMethodBeat.o(236228);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "delay", "", "getDelay", "()I", "setDelay", "(I)V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
  public static final class b
    extends a
  {
    private String effectId = "";
    public int fJe;
    public int version;
    
    public final void a(String paramString, XmlPullParser paramXmlPullParser)
    {
      AppMethodBeat.i(239496);
      p.k(paramString, "tag");
      p.k(paramXmlPullParser, "parser");
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
            AppMethodBeat.o(239496);
            return;
          } while (!paramString.equals("effectId"));
          this.effectId = d(paramXmlPullParser);
          AppMethodBeat.o(239496);
          return;
        } while (!paramString.equals("delay"));
        this.fJe = e(paramXmlPullParser);
        AppMethodBeat.o(239496);
        return;
      } while (!paramString.equals("effectVersion"));
      this.version = e(paramXmlPullParser);
      AppMethodBeat.o(239496);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */