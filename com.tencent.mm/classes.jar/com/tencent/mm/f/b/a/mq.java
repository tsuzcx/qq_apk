package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mq
  extends a
{
  private long gSh;
  private String gUA = "";
  private String gUB = "";
  private long gUC;
  private String gUD = "";
  private String gUE = "";
  private long gUF;
  private long gUG;
  private long gUH;
  private long gUI;
  private long gUJ;
  private String gUK = "";
  private long gUL;
  private long gUM;
  private long gUN;
  private long gUO;
  private long gUP;
  private long gUQ;
  private long gUR;
  private long gUS;
  private long gUT;
  private long gUU;
  private long gUV;
  private long gUW;
  private long gUX;
  private long gUY;
  private long gUZ;
  private String gUc = "";
  private String gUd = "";
  private String gUe = "";
  private long gVa;
  private long gVb;
  private long gVc;
  private long gVd;
  private long gVe;
  private String gVf = "";
  private int gVg;
  private int gVh;
  private long gVi;
  private long gVj;
  private long gVk;
  private String gVl = "";
  private String gVm = "";
  private long gVn;
  private String gVo = "";
  private String gVp = "";
  private String gjO = "";
  private long glw;
  private long gpu;
  
  public final mq Dh(String paramString)
  {
    AppMethodBeat.i(236156);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(236156);
    return this;
  }
  
  public final mq Di(String paramString)
  {
    AppMethodBeat.i(236158);
    this.gUA = z("CliPostID", paramString, true);
    AppMethodBeat.o(236158);
    return this;
  }
  
  public final mq Dj(String paramString)
  {
    AppMethodBeat.i(236160);
    this.gUB = z("StatusIcons", paramString, true);
    AppMethodBeat.o(236160);
    return this;
  }
  
  public final mq Dk(String paramString)
  {
    AppMethodBeat.i(236162);
    this.gUD = z("ExitTopicID", paramString, true);
    AppMethodBeat.o(236162);
    return this;
  }
  
  public final mq Dl(String paramString)
  {
    AppMethodBeat.i(236163);
    this.gUE = z("ExitTextStatusID", paramString, true);
    AppMethodBeat.o(236163);
    return this;
  }
  
  public final mq Dm(String paramString)
  {
    AppMethodBeat.i(236169);
    this.gUc = z("SourceID", paramString, true);
    AppMethodBeat.o(236169);
    return this;
  }
  
  public final mq Dn(String paramString)
  {
    AppMethodBeat.i(236171);
    this.gUd = z("SourceActivityID", paramString, true);
    AppMethodBeat.o(236171);
    return this;
  }
  
  public final mq Do(String paramString)
  {
    AppMethodBeat.i(236173);
    this.gUe = z("SourceName", paramString, true);
    AppMethodBeat.o(236173);
    return this;
  }
  
  public final mq Dp(String paramString)
  {
    AppMethodBeat.i(236174);
    this.gUK = z("SourceIcon", paramString, true);
    AppMethodBeat.o(236174);
    return this;
  }
  
  public final mq Dq(String paramString)
  {
    AppMethodBeat.i(236177);
    this.gVl = z("RefBackgroundUser", paramString, true);
    AppMethodBeat.o(236177);
    return this;
  }
  
  public final mq Dr(String paramString)
  {
    AppMethodBeat.i(236178);
    this.gVm = z("RefBackgroundStatus", paramString, true);
    AppMethodBeat.o(236178);
    return this;
  }
  
  public final mq Ds(String paramString)
  {
    AppMethodBeat.i(236179);
    this.gVo = z("ImgVideoMd5Orig", paramString, true);
    AppMethodBeat.o(236179);
    return this;
  }
  
  public final mq Dt(String paramString)
  {
    AppMethodBeat.i(236180);
    this.gVp = z("FinderPickerSessionId", paramString, true);
    AppMethodBeat.o(236180);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(236181);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVp);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(236181);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(236183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CliPostID:").append(this.gUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StatusIcons:").append(this.gUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitScene:").append(this.gUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTime:").append(this.gSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTopicID:").append(this.gUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTextStatusID:").append(this.gUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoOrigLength:").append(this.gUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFinalLength:").append(this.gUG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgVideoSize:").append(this.gUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgVideoSource:").append(this.gUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalTextLength:").append(this.gUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.gUc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceActivityID:").append(this.gUd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceName:").append(this.gUe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceIcon:").append(this.gUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditSourceTextCount:").append(this.gUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditSourceStatusIconCount:").append(this.gUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditSourceBackgroundCount:").append(this.gUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextTooLongHintCount:").append(this.gUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextTooShortHintCount:").append(this.gUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkReSelectStatusIconCount:").append(this.gUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkHashCount:").append(this.gUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkCamCount:").append(this.gUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkDelBackgroundCount:").append(this.gUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkChangeBackgroundCount:").append(this.gUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkPoiCount:").append(this.gUV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkReSelectPoiCount:").append(this.gUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalHasPoi:").append(this.gUX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkUserRangeCount:").append(this.gUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRangeSource:").append(this.gUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlurCount:").append(this.gVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnBlurCount:").append(this.gVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalHasBlur:").append(this.gVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkCustomIconCount:").append(this.gVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CustomTitleTooLongCount:").append(this.gVe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalCustomTitle:").append(this.gVf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserGuideShown:").append(this.gVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserGuideKnownClicked:").append(this.gVh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LimitFunc:").append(this.gVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkSightInSheet:").append(this.gVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClkAlbumInSheet:").append(this.gVk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefBackgroundUser:").append(this.gVl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefBackgroundStatus:").append(this.gVm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgVideoSizeOrig:").append(this.gVn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgVideoMd5Orig:").append(this.gVo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderPickerSessionId:").append(this.gVp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(236183);
    return localObject;
  }
  
  public final int getId()
  {
    return 22219;
  }
  
  public final mq nU(int paramInt)
  {
    this.gVg = paramInt;
    return this;
  }
  
  public final mq nV(int paramInt)
  {
    this.gVh = paramInt;
    return this;
  }
  
  public final mq yA(long paramLong)
  {
    this.gUV = paramLong;
    return this;
  }
  
  public final mq yB(long paramLong)
  {
    this.gUW = paramLong;
    return this;
  }
  
  public final mq yC(long paramLong)
  {
    this.gUX = paramLong;
    return this;
  }
  
  public final mq yD(long paramLong)
  {
    this.gUY = paramLong;
    return this;
  }
  
  public final mq yE(long paramLong)
  {
    this.gUZ = paramLong;
    return this;
  }
  
  public final mq yF(long paramLong)
  {
    this.gVa = paramLong;
    return this;
  }
  
  public final mq yG(long paramLong)
  {
    this.gVb = paramLong;
    return this;
  }
  
  public final mq yH(long paramLong)
  {
    this.gVc = paramLong;
    return this;
  }
  
  public final mq yI(long paramLong)
  {
    this.gVi = paramLong;
    return this;
  }
  
  public final mq yJ(long paramLong)
  {
    this.gVj = paramLong;
    return this;
  }
  
  public final mq yK(long paramLong)
  {
    this.gVk = paramLong;
    return this;
  }
  
  public final mq yL(long paramLong)
  {
    this.gVn = paramLong;
    return this;
  }
  
  public final mq yj(long paramLong)
  {
    this.gpu = paramLong;
    return this;
  }
  
  public final mq yk(long paramLong)
  {
    this.glw = paramLong;
    return this;
  }
  
  public final mq yl(long paramLong)
  {
    this.gUC = paramLong;
    return this;
  }
  
  public final mq ym(long paramLong)
  {
    this.gSh = paramLong;
    return this;
  }
  
  public final mq yn(long paramLong)
  {
    this.gUF = paramLong;
    return this;
  }
  
  public final mq yo(long paramLong)
  {
    this.gUG = paramLong;
    return this;
  }
  
  public final mq yp(long paramLong)
  {
    this.gUH = paramLong;
    return this;
  }
  
  public final mq yq(long paramLong)
  {
    this.gUI = paramLong;
    return this;
  }
  
  public final mq yr(long paramLong)
  {
    this.gUJ = paramLong;
    return this;
  }
  
  public final mq ys(long paramLong)
  {
    this.gUL = paramLong;
    return this;
  }
  
  public final mq yt(long paramLong)
  {
    this.gUM = paramLong;
    return this;
  }
  
  public final mq yu(long paramLong)
  {
    this.gUN = paramLong;
    return this;
  }
  
  public final mq yv(long paramLong)
  {
    this.gUO = paramLong;
    return this;
  }
  
  public final mq yw(long paramLong)
  {
    this.gUP = paramLong;
    return this;
  }
  
  public final mq yx(long paramLong)
  {
    this.gUQ = paramLong;
    return this;
  }
  
  public final mq yy(long paramLong)
  {
    this.gUR = paramLong;
    return this;
  }
  
  public final mq yz(long paramLong)
  {
    this.gUS = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mq
 * JD-Core Version:    0.7.0.1
 */