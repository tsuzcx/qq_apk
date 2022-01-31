package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "CanIgnoreBackground", "", "getCanIgnoreBackground", "()I", "setCanIgnoreBackground", "(I)V", "EmoticonImageSubtype", "getEmoticonImageSubtype", "setEmoticonImageSubtype", "EmoticonLensCaption", "Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangString;", "getEmoticonLensCaption", "()Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangString;", "setEmoticonLensCaption", "(Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangString;)V", "EmoticonLensCaptionColor", "", "getEmoticonLensCaptionColor", "()Ljava/lang/String;", "setEmoticonLensCaptionColor", "(Ljava/lang/String;)V", "EmoticonLensHongbaoCaption", "Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangStringWithScene;", "getEmoticonLensHongbaoCaption", "()Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangStringWithScene;", "setEmoticonLensHongbaoCaption", "(Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangStringWithScene;)V", "EmoticonLensHongbaoName", "getEmoticonLensHongbaoName", "setEmoticonLensHongbaoName", "EmoticonLensId", "getEmoticonLensId", "setEmoticonLensId", "EmoticonLensName", "getEmoticonLensName", "setEmoticonLensName", "EmoticonLensThumbImagePath", "getEmoticonLensThumbImagePath", "setEmoticonLensThumbImagePath", "EmoticonLensTipContent", "getEmoticonLensTipContent", "setEmoticonLensTipContent", "EmoticonLensTipImageList", "Lcom/tencent/mm/plugin/emojicapture/model/xml/StringList;", "getEmoticonLensTipImageList", "()Lcom/tencent/mm/plugin/emojicapture/model/xml/StringList;", "setEmoticonLensTipImageList", "(Lcom/tencent/mm/plugin/emojicapture/model/xml/StringList;)V", "EmoticonSubtype", "getEmoticonSubtype", "setEmoticonSubtype", "EmoticonVersion", "getEmoticonVersion", "setEmoticonVersion", "getLensCaption", "scene", "getLensName", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "toString", "plugin-emojicapture_release"})
public final class c
  extends a
{
  private String lvk;
  public int lvl;
  private int lvm;
  public int lvn;
  private d lvo;
  private d lvp;
  private String lvq;
  private d lvr;
  private e lvs;
  private String lvt;
  private int lvu;
  private d lvv;
  private i lvw;
  
  public c()
  {
    AppMethodBeat.i(2723);
    this.lvk = "";
    this.lvo = new d();
    this.lvp = new d();
    this.lvq = "";
    this.lvr = new d();
    this.lvs = new e();
    this.lvt = "";
    this.lvv = new d();
    this.lvw = new i("EmoticonLensTipImage");
    AppMethodBeat.o(2723);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2721);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              a(paramXmlPullParser);
                              AppMethodBeat.o(2721);
                              return;
                            } while (!paramString.equals("EmoticonVersion"));
                            this.lvn = e(paramXmlPullParser);
                            AppMethodBeat.o(2721);
                            return;
                          } while (!paramString.equals("EmoticonLensHongbaoCaption"));
                          this.lvs.f(paramXmlPullParser);
                          AppMethodBeat.o(2721);
                          return;
                        } while (!paramString.equals("EmoticonLensCaption"));
                        this.lvp.f(paramXmlPullParser);
                        AppMethodBeat.o(2721);
                        return;
                      } while (!paramString.equals("EmoticonLensThumbImagePath"));
                      this.lvt = d(paramXmlPullParser);
                      AppMethodBeat.o(2721);
                      return;
                    } while (!paramString.equals("CanIgnoreBackground"));
                    this.lvu = e(paramXmlPullParser);
                    AppMethodBeat.o(2721);
                    return;
                  } while (!paramString.equals("EmoticonImageSubtype"));
                  this.lvm = e(paramXmlPullParser);
                  AppMethodBeat.o(2721);
                  return;
                } while (!paramString.equals("EmoticonLensId"));
                this.lvk = d(paramXmlPullParser);
                AppMethodBeat.o(2721);
                return;
              } while (!paramString.equals("EmoticonLensTipImageList"));
              this.lvw.f(paramXmlPullParser);
              AppMethodBeat.o(2721);
              return;
            } while (!paramString.equals("EmoticonLensCaptionColor"));
            this.lvq = d(paramXmlPullParser);
            AppMethodBeat.o(2721);
            return;
          } while (!paramString.equals("EmoticonLensTipContent"));
          this.lvv.f(paramXmlPullParser);
          AppMethodBeat.o(2721);
          return;
        } while (!paramString.equals("EmoticonLensHongbaoName"));
        this.lvr.f(paramXmlPullParser);
        AppMethodBeat.o(2721);
        return;
      } while (!paramString.equals("EmoticonSubtype"));
      this.lvl = e(paramXmlPullParser);
      AppMethodBeat.o(2721);
      return;
    } while (!paramString.equals("EmoticonLensName"));
    this.lvo.f(paramXmlPullParser);
    AppMethodBeat.o(2721);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2722);
    String str = "EmoticonLensItem(EmoticonLensId='" + this.lvk + "',\n EmoticonSubtype=" + this.lvl + ",\n EmoticonLensName=" + this.lvo + ",\n EmoticonLensCaption=" + this.lvp + ",\n EmoticonLensCaptionColor='" + this.lvq + "',\n EmoticonLensHongbaoName=" + this.lvr + ",\n EmoticonLensHongbaoCaption=" + this.lvs + ",\n EmoticonLensThumbImagePath='" + this.lvt + "',\n CanIgnoreBackground=" + this.lvu + ",\n EmoticonLensTipContent=" + this.lvv + ')';
    AppMethodBeat.o(2722);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.c
 * JD-Core Version:    0.7.0.1
 */