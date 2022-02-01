package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.m;
import org.xmlpull.v1.XmlPullParser;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class p
  extends a
{
  final com.tencent.mm.be.l jIS;
  
  public p()
  {
    AppMethodBeat.i(105525);
    this.jIS = new com.tencent.mm.be.l();
    AppMethodBeat.o(105525);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105524);
    kotlin.g.b.p.k(paramString, "tag");
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
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
                                        this.jIS.lXD = d(paramXmlPullParser);
                                        AppMethodBeat.o(105524);
                                        return;
                                      } while (!paramString.equals("BackgroundLogo"));
                                      this.jIS.lXF = d(paramXmlPullParser);
                                      AppMethodBeat.o(105524);
                                      return;
                                    } while (!paramString.equals("UseLightStyle"));
                                    this.jIS.lXP = e(paramXmlPullParser);
                                    AppMethodBeat.o(105524);
                                    return;
                                  } while (!paramString.equals("SubTitleColor"));
                                  this.jIS.lXC = d(paramXmlPullParser);
                                  AppMethodBeat.o(105524);
                                  return;
                                } while (!paramString.equals("LoadingAnim"));
                                this.jIS.lXK = d(paramXmlPullParser);
                                AppMethodBeat.o(105524);
                                return;
                              } while (!paramString.equals("MainTitle"));
                              this.jIS.lXz = d(paramXmlPullParser);
                              AppMethodBeat.o(105524);
                              return;
                            } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                            this.jIS.lXH = d(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("MainTitleColor"));
                          this.jIS.lXA = d(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("DefaultCover"));
                        this.jIS.lXN = d(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("BrandName"));
                      this.jIS.fzM = d(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("AppId"));
                    this.jIS.appId = d(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("CouponBigTitle"));
                  this.jIS.lXI = d(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("ButtonTextColor"));
                this.jIS.lXM = d(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("ButtonBackgroundColor"));
              this.jIS.lXL = d(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponSmallTitle"));
            this.jIS.lXJ = d(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("SubTitle"));
          this.jIS.lXB = d(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
        this.jIS.lXG = d(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("BackgroundColor"));
      this.jIS.lXE = d(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("EntryAnimType"));
    paramString = new m();
    paramString.size = e(paramXmlPullParser, "size");
    paramString.fileName = d(paramXmlPullParser, "fileName");
    paramString.lXQ = e(paramXmlPullParser);
    this.jIS.lXO = paramString;
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.p
 * JD-Core Version:    0.7.0.1
 */