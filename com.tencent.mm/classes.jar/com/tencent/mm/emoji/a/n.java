package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.j;
import d.g.b.k;
import d.l;
import org.xmlpull.v1.XmlPullParser;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class n
  extends a
{
  final j fRh;
  
  public n()
  {
    AppMethodBeat.i(105525);
    this.fRh = new j();
    AppMethodBeat.o(105525);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105524);
    k.h(paramString, "tag");
    k.h(paramXmlPullParser, "parser");
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
                              AppMethodBeat.o(105524);
                              return;
                            } while (!paramString.equals("BrandIcon"));
                            this.fRh.hPR = d(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("BackgroundLogo"));
                          this.fRh.hPT = d(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("SubTitleColor"));
                        this.fRh.hPQ = d(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("MainTitle"));
                      this.fRh.hPN = d(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                    this.fRh.hPV = d(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("MainTitleColor"));
                  this.fRh.hPO = d(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("BrandName"));
                this.fRh.ddh = d(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("AppId"));
              this.fRh.appId = d(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponBigTitle"));
            this.fRh.hPW = d(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("CouponSmallTitle"));
          this.fRh.hPX = d(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("SubTitle"));
        this.fRh.hPP = d(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
      this.fRh.hPU = d(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("BackgroundColor"));
    this.fRh.hPS = d(paramXmlPullParser);
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.n
 * JD-Core Version:    0.7.0.1
 */