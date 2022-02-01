package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.k;
import kotlin.g.b.p;
import org.xmlpull.v1.XmlPullParser;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class o
  extends a
{
  final k gXT;
  
  public o()
  {
    AppMethodBeat.i(105525);
    this.gXT = new k();
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
                                      this.gXT.jhb = d(paramXmlPullParser);
                                      AppMethodBeat.o(105524);
                                      return;
                                    } while (!paramString.equals("BackgroundLogo"));
                                    this.gXT.jhd = d(paramXmlPullParser);
                                    AppMethodBeat.o(105524);
                                    return;
                                  } while (!paramString.equals("SubTitleColor"));
                                  this.gXT.jha = d(paramXmlPullParser);
                                  AppMethodBeat.o(105524);
                                  return;
                                } while (!paramString.equals("LoadingAnim"));
                                this.gXT.jhi = d(paramXmlPullParser);
                                AppMethodBeat.o(105524);
                                return;
                              } while (!paramString.equals("MainTitle"));
                              this.gXT.jgX = d(paramXmlPullParser);
                              AppMethodBeat.o(105524);
                              return;
                            } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                            this.gXT.jhf = d(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("MainTitleColor"));
                          this.gXT.jgY = d(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("DefaultCover"));
                        this.gXT.jhl = d(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("BrandName"));
                      this.gXT.brandName = d(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("AppId"));
                    this.gXT.appId = d(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("CouponBigTitle"));
                  this.gXT.jhg = d(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("ButtonTextColor"));
                this.gXT.jhk = d(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("ButtonBackgroundColor"));
              this.gXT.jhj = d(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponSmallTitle"));
            this.gXT.jhh = d(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("SubTitle"));
          this.gXT.jgZ = d(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
        this.gXT.jhe = d(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("BackgroundColor"));
      this.gXT.jhc = d(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("EntryAnimType"));
    paramString = new com.tencent.mm.bb.l();
    paramString.size = e(paramXmlPullParser, "size");
    paramString.fileName = d(paramXmlPullParser, "fileName");
    paramString.jhn = e(paramXmlPullParser);
    this.gXT.jhm = paramString;
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.b.o
 * JD-Core Version:    0.7.0.1
 */