package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "EmojiAnimItem", "EmojiAnimScreenEffect", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public final ArrayList<a> mfy;
  public int version;
  
  public b()
  {
    AppMethodBeat.i(242304);
    this.mfy = new ArrayList();
    AppMethodBeat.o(242304);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(242311);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
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
          AppMethodBeat.o(242311);
          return;
        } while (!paramString.equals("emojiAnimVersion"));
        this.version = g(paramXmlPullParser);
        AppMethodBeat.o(242311);
        return;
      } while (!paramString.equals("item"));
      paramString = new a();
      paramString.e(paramXmlPullParser);
      this.mfy.add(paramString);
      AppMethodBeat.o(242311);
      return;
    } while (!paramString.equals("emoji"));
    AppMethodBeat.o(242311);
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(242307);
    s.u(paramXmlPullParser, "parser");
    this.mfy.clear();
    super.e(paramXmlPullParser);
    AppMethodBeat.o(242307);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "animFile", "", "getAnimFile", "()Ljava/lang/String;", "setAnimFile", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "screenEffect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "getScreenEffect", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "setScreenEffect", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;)V", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends a
  {
    public String key = "";
    public b.b mfA;
    public String mfz = "";
    
    public final void a(String paramString, XmlPullParser paramXmlPullParser)
    {
      AppMethodBeat.i(242297);
      s.u(paramString, "tag");
      s.u(paramXmlPullParser, "parser");
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
            AppMethodBeat.o(242297);
            return;
          } while (!paramString.equals("animFile"));
          this.mfz = f(paramXmlPullParser);
          AppMethodBeat.o(242297);
          return;
        } while (!paramString.equals("key"));
        this.key = f(paramXmlPullParser);
        AppMethodBeat.o(242297);
        return;
      } while (!paramString.equals("screenEffect"));
      paramString = new b.b();
      paramString.e(paramXmlPullParser);
      paramXmlPullParser = ah.aiuX;
      this.mfA = paramString;
      AppMethodBeat.o(242297);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "delay", "", "getDelay", "()I", "setDelay", "(I)V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a
  {
    public int UZ;
    private String mfB = "";
    public int version;
    
    public final void a(String paramString, XmlPullParser paramXmlPullParser)
    {
      AppMethodBeat.i(242295);
      s.u(paramString, "tag");
      s.u(paramXmlPullParser, "parser");
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
            AppMethodBeat.o(242295);
            return;
          } while (!paramString.equals("effectId"));
          this.mfB = f(paramXmlPullParser);
          AppMethodBeat.o(242295);
          return;
        } while (!paramString.equals("delay"));
        this.UZ = g(paramXmlPullParser);
        AppMethodBeat.o(242295);
        return;
      } while (!paramString.equals("effectVersion"));
      this.version = g(paramXmlPullParser);
      AppMethodBeat.o(242295);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b
 * JD-Core Version:    0.7.0.1
 */