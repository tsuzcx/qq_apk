package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.m;
import com.tencent.mm.modelpackage.n;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends a
{
  final m mij;
  
  public p()
  {
    AppMethodBeat.i(105525);
    this.mij = new m();
    AppMethodBeat.o(105525);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105524);
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
                                        this.mij.oQH = f(paramXmlPullParser);
                                        AppMethodBeat.o(105524);
                                        return;
                                      } while (!paramString.equals("BackgroundLogo"));
                                      this.mij.oQJ = f(paramXmlPullParser);
                                      AppMethodBeat.o(105524);
                                      return;
                                    } while (!paramString.equals("UseLightStyle"));
                                    this.mij.oQT = g(paramXmlPullParser);
                                    AppMethodBeat.o(105524);
                                    return;
                                  } while (!paramString.equals("SubTitleColor"));
                                  this.mij.oQG = f(paramXmlPullParser);
                                  AppMethodBeat.o(105524);
                                  return;
                                } while (!paramString.equals("LoadingAnim"));
                                this.mij.oQO = f(paramXmlPullParser);
                                AppMethodBeat.o(105524);
                                return;
                              } while (!paramString.equals("MainTitle"));
                              this.mij.oQD = f(paramXmlPullParser);
                              AppMethodBeat.o(105524);
                              return;
                            } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                            this.mij.oQL = f(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("MainTitleColor"));
                          this.mij.oQE = f(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("DefaultCover"));
                        this.mij.oQR = f(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("BrandName"));
                      this.mij.hEy = f(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("AppId"));
                    this.mij.appId = f(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("CouponBigTitle"));
                  this.mij.oQM = f(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("ButtonTextColor"));
                this.mij.oQQ = f(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("ButtonBackgroundColor"));
              this.mij.oQP = f(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponSmallTitle"));
            this.mij.oQN = f(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("SubTitle"));
          this.mij.oQF = f(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
        this.mij.oQK = f(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("BackgroundColor"));
      this.mij.oQI = f(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("EntryAnimType"));
    paramString = new n();
    paramString.size = f(paramXmlPullParser, "size");
    paramString.fileName = e(paramXmlPullParser, "fileName");
    paramString.oQU = g(paramXmlPullParser);
    this.mij.oQS = paramString;
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.emoji.c.p
 * JD-Core Version:    0.7.0.1
 */