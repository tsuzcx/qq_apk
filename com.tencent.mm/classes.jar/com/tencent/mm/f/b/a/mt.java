package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mt
  extends a
{
  public String gVA = "";
  public int gVB = -1;
  public int gVC = -1;
  public String gVD = "";
  private int gVE = -1;
  public int gVF = -1;
  public String gVG = "";
  public int gVH = -1;
  public int gVI = -1;
  public String gVJ = "";
  public int gVK = -1;
  public int gVL = -1;
  public String gVM = "";
  public String gVN = "";
  public String gVO = "";
  private long gVP;
  public String gVQ = "";
  public int gVs = -1;
  public int gVt = -1;
  public int gVu = -1;
  public int gVv = -1;
  public String gVw = "";
  public int gVx = -1;
  public String gVy = "";
  public int gVz = -1;
  private String gjO = "";
  
  public final mt Dw(String paramString)
  {
    AppMethodBeat.i(176225);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(176225);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94856);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94857);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VisibleButtonClickNum:").append(this.gVs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingisShow:").append(this.gVt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingisClick:").append(this.gVu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingGroupCount:").append(this.gVv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingGroupList:").append(this.gVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingUinCount:").append(this.gVx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingUinList:").append(this.gVy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingLabelCount:").append(this.gVz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LatestTimelinePsotSettingLabelList:").append(this.gVA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelinePsotPrivaceSetting:").append(this.gVB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectFromChatroomClickNum:").append(this.gVC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMemClickList:").append(this.gVD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMemClickNum:").append(this.gVE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectedChatroomNum:").append(this.gVF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectedChatroomList:").append(this.gVG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectFromContactClickNum:").append(this.gVH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectedUINNum:").append(this.gVI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectedUINList:").append(this.gVJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostStatus:").append(this.gVK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectedLabelNum:").append(this.gVL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelectedLabelList:").append(this.gVM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Published:").append(this.gVN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMemClickNumList:").append(this.gVO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageOrVideoPublishId:").append(this.gVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaEditedPublishIds:").append(this.gVQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94857);
    return localObject;
  }
  
  public final int getId()
  {
    return 17367;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mt
 * JD-Core Version:    0.7.0.1
 */