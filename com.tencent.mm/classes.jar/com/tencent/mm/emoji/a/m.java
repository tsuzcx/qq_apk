package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.j;
import d.g.b.k;
import d.l;
import org.xmlpull.v1.XmlPullParser;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class m
  extends a
{
  final j fNw;
  
  public m()
  {
    AppMethodBeat.i(105525);
    this.fNw = new j();
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
                            this.fNw.hpp = o(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("BackgroundLogo"));
                          this.fNw.hpr = o(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("SubTitleColor"));
                        this.fNw.hpo = o(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("MainTitle"));
                      this.fNw.hpl = o(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                    this.fNw.hpt = o(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("MainTitleColor"));
                  this.fNw.hpm = o(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("BrandName"));
                this.fNw.dfM = o(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("AppId"));
              this.fNw.appId = o(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponBigTitle"));
            this.fNw.hpu = o(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("CouponSmallTitle"));
          this.fNw.hpv = o(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("SubTitle"));
        this.fNw.hpn = o(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
      this.fNw.hps = o(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("BackgroundColor"));
    this.fNw.hpq = o(paramXmlPullParser);
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.m
 * JD-Core Version:    0.7.0.1
 */