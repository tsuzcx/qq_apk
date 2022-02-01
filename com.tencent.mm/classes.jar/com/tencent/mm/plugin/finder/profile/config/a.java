package com.tencent.mm.plugin.finder.profile.config;

import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.profile.uihandler.b;
import com.tencent.mm.plugin.finder.profile.uihandler.c;
import com.tencent.mm.plugin.finder.profile.uihandler.d;
import com.tencent.mm.plugin.finder.profile.uihandler.f;
import com.tencent.mm.plugin.finder.profile.uihandler.g;
import com.tencent.mm.plugin.finder.profile.uihandler.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/config/ProfileCoverConfig;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "bgAlpha1Ids", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bgFg2Ids", "bw97Color", "bwAlpha1Color", "color01White", "color03White", "color05Black", "color05White", "color08White", "color09Black", "color09White", "colorBlack", "colorFg0", "colorFg05", "colorFg1", "colorFg2", "colorWhite", "covered09Black", "coveredWeImageSrcList", "Lkotlin/Pair;", "extractColorIconStyle", "Lcom/tencent/mm/plugin/finder/profile/uihandler/WeImageColorStyleActionHandler;", "extractColorTextStyle", "Lcom/tencent/mm/plugin/finder/profile/uihandler/TextStyleActionHandler;", "iconColorNullIds", "iconCoveredBlack09Ids", "iconExtractColorIds", "iconFg05Ids", "iconFg0Ids", "iconFg1Ids", "iconFg2Ids", "iconLink80Ids", "iconLiveIds", "iconOrangeIds", "iconPurpleIds", "iconWhite03Ids", "iconWhite05Ids", "iconWhite08Ids", "iconWhiteIds", "isCoveredConfigInit", "", "link100Color", "linkColor", "liveColor", "normalWeImageSrcList", "orangeColor", "purpleColor", "textBlack05Ids", "textBlack09Ids", "textBlackIds", "textCoveredBlack09Ids", "textExtractColorIds", "textFg0Ids", "textFg1Ids", "textLink80Ids", "textLinkIds", "textNormalWhiteIds", "textWhite05Ids", "textWhite08Ids", "textWhite09Ids", "textWhiteIds", "uiStyleManager", "Lcom/tencent/mm/plugin/finder/profile/uihandler/FinderUiStyleManager;", "Landroid/view/View;", "viewBgBw97Ids", "viewBgCoveredBw97Ids", "viewBgFg1Ids", "viewBgWhite01Ids", "viewBgWhite08Ids", "viewBgWhiteIds", "initCoverConfig", "", "initCoveredIds", "initNormalConfig", "initNormalIds", "onCreate", "refreshExtractColor", "extractColor", "setStyle", "style", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Fbd;
  public d FbA;
  public g FbB;
  public final ArrayList<Integer> FbC;
  public final ArrayList<Integer> FbD;
  public final ArrayList<Integer> FbE;
  public final ArrayList<Integer> FbF;
  public final ArrayList<Integer> FbG;
  public final ArrayList<Integer> FbH;
  public final ArrayList<Integer> FbI;
  public final ArrayList<Integer> FbJ;
  public final ArrayList<Integer> FbK;
  public final ArrayList<Integer> FbL;
  private final ArrayList<Integer> FbM;
  public final ArrayList<Integer> FbN;
  public final ArrayList<Integer> FbO;
  private final ArrayList<Integer> FbP;
  public final ArrayList<Integer> FbQ;
  public final ArrayList<Integer> FbR;
  public final ArrayList<Integer> FbS;
  public final ArrayList<Integer> FbT;
  public final ArrayList<Integer> FbU;
  public final ArrayList<Integer> FbV;
  public final ArrayList<Integer> FbW;
  public final ArrayList<Integer> FbX;
  public final ArrayList<Integer> FbY;
  public final ArrayList<Integer> FbZ;
  private boolean Fbe;
  public final int Fbf;
  private final int Fbg;
  private final int Fbh;
  private final int Fbi;
  private final int Fbj;
  private final int Fbk;
  private final int Fbl;
  public final int Fbm;
  public final int Fbn;
  public final int Fbo;
  public final int Fbp;
  public final int Fbq;
  public final int Fbr;
  public final int Fbs;
  public final int Fbt;
  public final int Fbu;
  public final int Fbv;
  public final int Fbw;
  public final int Fbx;
  public final int Fby;
  public final com.tencent.mm.plugin.finder.profile.uihandler.a<Integer, View> Fbz;
  public final ArrayList<Integer> Fca;
  public final ArrayList<Integer> Fcb;
  public final ArrayList<Integer> Fcc;
  public final ArrayList<Integer> Fcd;
  public final ArrayList<Integer> Fce;
  public final ArrayList<Integer> Fcf;
  public final ArrayList<Integer> Fcg;
  public final ArrayList<Integer> Fch;
  public final ArrayList<Integer> Fci;
  public final ArrayList<Integer> Fcj;
  public final ArrayList<Integer> Fck;
  public final ArrayList<Integer> Fcl;
  public final ArrayList<Integer> Fcm;
  public final ArrayList<r<Integer, Integer>> Fcn;
  public final ArrayList<r<Integer, Integer>> Fco;
  public final AppCompatActivity activity;
  public final int linkColor;
  
  static
  {
    AppMethodBeat.i(348411);
    Fbd = new a((byte)0);
    AppMethodBeat.o(348411);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(348405);
    this.activity = paramAppCompatActivity;
    this.Fbf = this.activity.getResources().getColor(e.b.White);
    this.Fbg = this.activity.getResources().getColor(e.b.finder_Alpha_0_9_White_Mode);
    this.Fbh = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_9_Night_Mode);
    this.Fbi = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_5_Night_Mode);
    this.Fbj = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_3_White_Mode);
    this.Fbk = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_1_Night_Mode);
    this.Fbl = this.activity.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_9);
    this.Fbm = this.activity.getResources().getColor(e.b.black_color);
    this.Fbn = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_9);
    this.Fbo = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_5);
    this.Fbp = this.activity.getResources().getColor(e.b.FG_0);
    this.Fbq = this.activity.getResources().getColor(e.b.FG_0_5);
    this.Fbr = this.activity.getResources().getColor(e.b.FG_1);
    this.Fbs = this.activity.getResources().getColor(e.b.FG_2);
    this.linkColor = this.activity.getResources().getColor(e.b.Link_100);
    this.Fbt = this.activity.getResources().getColor(e.b.Link_100);
    this.Fbu = this.activity.getResources().getColor(e.b.finder_live_logo_color);
    this.Fbv = this.activity.getResources().getColor(e.b.Purple_100);
    this.Fbw = this.activity.getResources().getColor(e.b.Orange);
    this.Fbx = this.activity.getResources().getColor(e.b.BW_0_Alpha_0_1);
    this.Fby = this.activity.getResources().getColor(e.b.BW_97);
    this.Fbz = new com.tencent.mm.plugin.finder.profile.uihandler.a();
    this.FbC = new ArrayList();
    this.FbD = new ArrayList();
    this.FbE = new ArrayList();
    this.FbF = new ArrayList();
    this.FbG = new ArrayList();
    this.FbH = new ArrayList();
    this.FbI = new ArrayList();
    this.FbJ = new ArrayList();
    this.FbK = new ArrayList();
    this.FbL = new ArrayList();
    this.FbM = new ArrayList();
    this.FbN = new ArrayList();
    this.FbO = new ArrayList();
    this.FbP = new ArrayList();
    this.FbQ = new ArrayList();
    this.FbR = new ArrayList();
    this.FbS = new ArrayList();
    this.FbT = new ArrayList();
    this.FbU = new ArrayList();
    this.FbV = new ArrayList();
    this.FbW = new ArrayList();
    this.FbX = new ArrayList();
    this.FbY = new ArrayList();
    this.FbZ = new ArrayList();
    this.Fca = new ArrayList();
    this.Fcb = new ArrayList();
    this.Fcc = new ArrayList();
    this.Fcd = new ArrayList();
    this.Fce = new ArrayList();
    this.Fcf = new ArrayList();
    this.Fcg = new ArrayList();
    this.Fch = new ArrayList();
    this.Fci = new ArrayList();
    this.Fcj = new ArrayList();
    this.Fck = new ArrayList();
    this.Fcl = new ArrayList();
    this.Fcm = new ArrayList();
    this.Fcn = new ArrayList();
    this.Fco = new ArrayList();
    AppMethodBeat.o(348405);
  }
  
  public final void RF(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(348436);
    d locald = this.FbA;
    Object localObject1 = locald;
    if (locald == null)
    {
      s.bIx("extractColorTextStyle");
      localObject1 = null;
    }
    ((d)localObject1).textColor = paramInt;
    localObject1 = this.FbB;
    if (localObject1 == null)
    {
      s.bIx("extractColorIconStyle");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((g)localObject1).Fgw = Integer.valueOf(paramInt);
      AppMethodBeat.o(348436);
      return;
    }
  }
  
  public final void setStyle(int paramInt)
  {
    AppMethodBeat.i(348428);
    if (!this.Fbe)
    {
      this.Fbe = true;
      com.tencent.mm.plugin.finder.profile.uihandler.a locala = this.Fbz;
      Object localObject2 = this.FbA;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("extractColorTextStyle");
        localObject1 = null;
      }
      b localb = (b)localObject1;
      localObject2 = this.FbB;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("extractColorIconStyle");
        localObject1 = null;
      }
      locala.a(Integer.valueOf(200), (Set)ar.an(new b[] { localb, (b)localObject1, (b)new h(this.activity, (List)this.Fco), (b)new f(this.activity, this.Fbf, (List)this.FbM), (b)new f(this.activity, this.Fbk, (List)this.FbN), (b)new f(this.activity, this.Fbh, (List)this.FbO), (b)new d(this.activity, this.Fbi, (List)this.FbK), (b)new d(this.activity, this.Fbh, (List)this.FbJ), (b)new d(this.activity, this.Fbg, (List)this.FbI), (b)new d(this.activity, this.Fbf, (List)this.FbH), (b)new d(this.activity, this.Fbl, (List)this.FbL), (b)new g(this.activity, Integer.valueOf(this.Fbh), (List)this.FbC, null, 8), (b)new g(this.activity, Integer.valueOf(this.Fbi), (List)this.FbD, null, 8), (b)new g(this.activity, Integer.valueOf(this.Fbj), (List)this.FbE, null, 8), (b)new g(this.activity, Integer.valueOf(this.Fbf), (List)this.FbF, null, 8), (b)new g(this.activity, Integer.valueOf(this.Fbl), (List)this.FbG, null, 8), (b)new c(this.activity, true, "ProfileStyle", 0) }));
    }
    Object localObject1 = (Set)this.Fbz.FfX.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      if (!((Collection)localObject1).isEmpty()) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((b)((Iterator)localObject1).next()).eKx();
        }
      }
    }
    AppMethodBeat.o(348428);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/config/ProfileCoverConfig$Companion;", "", "()V", "GROUP_COVERED_STYLE", "", "GROUP_NORMAL_STYLE", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.config.a
 * JD-Core Version:    0.7.0.1
 */