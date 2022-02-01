package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.j;
import d.g.b.p;
import d.l;
import org.xmlpull.v1.XmlPullParser;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class n
  extends a
{
  final j gkH;
  
  public n()
  {
    AppMethodBeat.i(105525);
    this.gkH = new j();
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
                            this.gkH.ijf = c(paramXmlPullParser);
                            AppMethodBeat.o(105524);
                            return;
                          } while (!paramString.equals("BackgroundLogo"));
                          this.gkH.ijh = c(paramXmlPullParser);
                          AppMethodBeat.o(105524);
                          return;
                        } while (!paramString.equals("SubTitleColor"));
                        this.gkH.ije = c(paramXmlPullParser);
                        AppMethodBeat.o(105524);
                        return;
                      } while (!paramString.equals("MainTitle"));
                      this.gkH.ijb = c(paramXmlPullParser);
                      AppMethodBeat.o(105524);
                      return;
                    } while (!paramString.equals("RedEnvelopeCoverSmallTitle"));
                    this.gkH.ijj = c(paramXmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                  } while (!paramString.equals("MainTitleColor"));
                  this.gkH.ijc = c(paramXmlPullParser);
                  AppMethodBeat.o(105524);
                  return;
                } while (!paramString.equals("BrandName"));
                this.gkH.doD = c(paramXmlPullParser);
                AppMethodBeat.o(105524);
                return;
              } while (!paramString.equals("AppId"));
              this.gkH.appId = c(paramXmlPullParser);
              AppMethodBeat.o(105524);
              return;
            } while (!paramString.equals("CouponBigTitle"));
            this.gkH.ijk = c(paramXmlPullParser);
            AppMethodBeat.o(105524);
            return;
          } while (!paramString.equals("CouponSmallTitle"));
          this.gkH.ijl = c(paramXmlPullParser);
          AppMethodBeat.o(105524);
          return;
        } while (!paramString.equals("SubTitle"));
        this.gkH.ijd = c(paramXmlPullParser);
        AppMethodBeat.o(105524);
        return;
      } while (!paramString.equals("RedEnvelopeCoverBigTitle"));
      this.gkH.iji = c(paramXmlPullParser);
      AppMethodBeat.o(105524);
      return;
    } while (!paramString.equals("BackgroundColor"));
    this.gkH.ijg = c(paramXmlPullParser);
    AppMethodBeat.o(105524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.n
 * JD-Core Version:    0.7.0.1
 */