package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.j;
import d.g.b.p;
import d.l;
import org.xmlpull.v1.XmlPullParser;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class n
  extends a
{
  final j gnb;
  
  public n()
  {
    AppMethodBeat.i(105525);
    this.gnb = new j();
    AppMethodBeat.o(105525);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105524);
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
                              skip(paramXmlPullParser);
                              AppMethodBeat.o(105524);
                              return;
                            } while (!paramString.equals("BrandIcon"));
                            this.gnb.ilY = c(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("BackgroundLogo"));
                          this.gnb.ima = c(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("SubTitleColor"));
                        this.gnb.ilX = c(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("MainTitle"));
                      this.gnb.ilU = c(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                    this.gnb.imc = c(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("MainTitleColor"));
                  this.gnb.ilV = c(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("BrandName"));
                this.gnb.dpI = c(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("AppId"));
              this.gnb.appId = c(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponBigTitle"));
            this.gnb.imd = c(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("CouponSmallTitle"));
          this.gnb.ime = c(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("SubTitle"));
        this.gnb.ilW = c(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
      this.gnb.imb = c(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("BackgroundColor"));
    this.gnb.ilZ = c(paramXmlPullParser);
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.n
 * JD-Core Version:    0.7.0.1
 */