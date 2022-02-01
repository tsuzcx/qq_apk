package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public class GetGameCenterGlobalSettingResponse
  extends dyy
{
  public a A8Key;
  public String AppStoreGoodsId;
  public i AppStorePreload;
  public l AutoRunTaskSetting;
  public s CommJsLib;
  public y DownloadIntercept;
  public aj GameCenterTabSetting;
  public ak GameCommunityInfo;
  public ao GameDetailSetting;
  public aw GameIndexSetting;
  public bc GameLifeSetting;
  public bi GeneralJumpInfo;
  public boolean ShowEntrance;
  public dw StatusBarStyle;
  public en WebViewControl;
  public eo WepkgControl;
  public z downloaderApp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(149416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.ShowEntrance);
      if (this.GameIndexSetting != null)
      {
        paramVarArgs.oE(3, this.GameIndexSetting.computeSize());
        this.GameIndexSetting.writeFields(paramVarArgs);
      }
      if (this.AppStoreGoodsId != null) {
        paramVarArgs.f(4, this.AppStoreGoodsId);
      }
      if (this.GameDetailSetting != null)
      {
        paramVarArgs.oE(6, this.GameDetailSetting.computeSize());
        this.GameDetailSetting.writeFields(paramVarArgs);
      }
      if (this.AppStorePreload != null)
      {
        paramVarArgs.oE(7, this.AppStorePreload.computeSize());
        this.AppStorePreload.writeFields(paramVarArgs);
      }
      if (this.StatusBarStyle != null)
      {
        paramVarArgs.oE(8, this.StatusBarStyle.computeSize());
        this.StatusBarStyle.writeFields(paramVarArgs);
      }
      if (this.CommJsLib != null)
      {
        paramVarArgs.oE(11, this.CommJsLib.computeSize());
        this.CommJsLib.writeFields(paramVarArgs);
      }
      if (this.WepkgControl != null)
      {
        paramVarArgs.oE(12, this.WepkgControl.computeSize());
        this.WepkgControl.writeFields(paramVarArgs);
      }
      if (this.downloaderApp != null)
      {
        paramVarArgs.oE(13, this.downloaderApp.computeSize());
        this.downloaderApp.writeFields(paramVarArgs);
      }
      if (this.WebViewControl != null)
      {
        paramVarArgs.oE(14, this.WebViewControl.computeSize());
        this.WebViewControl.writeFields(paramVarArgs);
      }
      if (this.DownloadIntercept != null)
      {
        paramVarArgs.oE(15, this.DownloadIntercept.computeSize());
        this.DownloadIntercept.writeFields(paramVarArgs);
      }
      if (this.A8Key != null)
      {
        paramVarArgs.oE(16, this.A8Key.computeSize());
        this.A8Key.writeFields(paramVarArgs);
      }
      if (this.AutoRunTaskSetting != null)
      {
        paramVarArgs.oE(17, this.AutoRunTaskSetting.computeSize());
        this.AutoRunTaskSetting.writeFields(paramVarArgs);
      }
      if (this.GameCenterTabSetting != null)
      {
        paramVarArgs.oE(18, this.GameCenterTabSetting.computeSize());
        this.GameCenterTabSetting.writeFields(paramVarArgs);
      }
      if (this.GameLifeSetting != null)
      {
        paramVarArgs.oE(19, this.GameLifeSetting.computeSize());
        this.GameLifeSetting.writeFields(paramVarArgs);
      }
      if (this.GeneralJumpInfo != null)
      {
        paramVarArgs.oE(20, this.GeneralJumpInfo.computeSize());
        this.GeneralJumpInfo.writeFields(paramVarArgs);
      }
      if (this.GameCommunityInfo != null)
      {
        paramVarArgs.oE(21, this.GameCommunityInfo.computeSize());
        this.GameCommunityInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2458;
      }
    }
    label2458:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.GameIndexSetting != null) {
        paramInt = i + g.a.a.a.oD(3, this.GameIndexSetting.computeSize());
      }
      i = paramInt;
      if (this.AppStoreGoodsId != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.AppStoreGoodsId);
      }
      paramInt = i;
      if (this.GameDetailSetting != null) {
        paramInt = i + g.a.a.a.oD(6, this.GameDetailSetting.computeSize());
      }
      i = paramInt;
      if (this.AppStorePreload != null) {
        i = paramInt + g.a.a.a.oD(7, this.AppStorePreload.computeSize());
      }
      paramInt = i;
      if (this.StatusBarStyle != null) {
        paramInt = i + g.a.a.a.oD(8, this.StatusBarStyle.computeSize());
      }
      i = paramInt;
      if (this.CommJsLib != null) {
        i = paramInt + g.a.a.a.oD(11, this.CommJsLib.computeSize());
      }
      paramInt = i;
      if (this.WepkgControl != null) {
        paramInt = i + g.a.a.a.oD(12, this.WepkgControl.computeSize());
      }
      i = paramInt;
      if (this.downloaderApp != null) {
        i = paramInt + g.a.a.a.oD(13, this.downloaderApp.computeSize());
      }
      paramInt = i;
      if (this.WebViewControl != null) {
        paramInt = i + g.a.a.a.oD(14, this.WebViewControl.computeSize());
      }
      i = paramInt;
      if (this.DownloadIntercept != null) {
        i = paramInt + g.a.a.a.oD(15, this.DownloadIntercept.computeSize());
      }
      paramInt = i;
      if (this.A8Key != null) {
        paramInt = i + g.a.a.a.oD(16, this.A8Key.computeSize());
      }
      i = paramInt;
      if (this.AutoRunTaskSetting != null) {
        i = paramInt + g.a.a.a.oD(17, this.AutoRunTaskSetting.computeSize());
      }
      paramInt = i;
      if (this.GameCenterTabSetting != null) {
        paramInt = i + g.a.a.a.oD(18, this.GameCenterTabSetting.computeSize());
      }
      i = paramInt;
      if (this.GameLifeSetting != null) {
        i = paramInt + g.a.a.a.oD(19, this.GameLifeSetting.computeSize());
      }
      paramInt = i;
      if (this.GeneralJumpInfo != null) {
        paramInt = i + g.a.a.a.oD(20, this.GeneralJumpInfo.computeSize());
      }
      i = paramInt;
      if (this.GameCommunityInfo != null) {
        i = paramInt + g.a.a.a.oD(21, this.GameCommunityInfo.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(149416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetGameCenterGlobalSettingResponse localGetGameCenterGlobalSettingResponse = (GetGameCenterGlobalSettingResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(149416);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localGetGameCenterGlobalSettingResponse.ShowEntrance = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aw)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameIndexSetting = ((aw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localGetGameCenterGlobalSettingResponse.AppStoreGoodsId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ao)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameDetailSetting = ((ao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new i();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((i)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.AppStorePreload = ((i)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dw)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.StatusBarStyle = ((dw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new s();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((s)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.CommJsLib = ((s)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.WepkgControl = ((eo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new z();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((z)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.downloaderApp = ((z)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new en();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((en)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.WebViewControl = ((en)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new y();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((y)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.DownloadIntercept = ((y)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.A8Key = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new l();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((l)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.AutoRunTaskSetting = ((l)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aj)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameCenterTabSetting = ((aj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bc)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameLifeSetting = ((bc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bi)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GeneralJumpInfo = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ak();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ak)localObject2).parseFrom((byte[])localObject1);
          }
          localGetGameCenterGlobalSettingResponse.GameCommunityInfo = ((ak)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      AppMethodBeat.o(149416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse
 * JD-Core Version:    0.7.0.1
 */