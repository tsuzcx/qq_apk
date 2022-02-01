package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public class GetGameCenterGlobalSettingResponse
  extends esc
{
  public a A8Key;
  public String AppStoreGoodsId;
  public i AppStorePreload;
  public m AutoRunTaskSetting;
  public t CommJsLib;
  public z DownloadIntercept;
  public ak GameCenterTabSetting;
  public al GameCommunityInfo;
  public ap GameDetailSetting;
  public ax GameIndexSetting;
  public bd GameLifeSetting;
  public bj GeneralJumpInfo;
  public boolean ShowEntrance;
  public ea StatusBarStyle;
  public es WebViewControl;
  public et WepkgControl;
  public aa downloaderApp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(149416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.ShowEntrance);
      if (this.GameIndexSetting != null)
      {
        paramVarArgs.qD(3, this.GameIndexSetting.computeSize());
        this.GameIndexSetting.writeFields(paramVarArgs);
      }
      if (this.AppStoreGoodsId != null) {
        paramVarArgs.g(4, this.AppStoreGoodsId);
      }
      if (this.GameDetailSetting != null)
      {
        paramVarArgs.qD(6, this.GameDetailSetting.computeSize());
        this.GameDetailSetting.writeFields(paramVarArgs);
      }
      if (this.AppStorePreload != null)
      {
        paramVarArgs.qD(7, this.AppStorePreload.computeSize());
        this.AppStorePreload.writeFields(paramVarArgs);
      }
      if (this.StatusBarStyle != null)
      {
        paramVarArgs.qD(8, this.StatusBarStyle.computeSize());
        this.StatusBarStyle.writeFields(paramVarArgs);
      }
      if (this.CommJsLib != null)
      {
        paramVarArgs.qD(11, this.CommJsLib.computeSize());
        this.CommJsLib.writeFields(paramVarArgs);
      }
      if (this.WepkgControl != null)
      {
        paramVarArgs.qD(12, this.WepkgControl.computeSize());
        this.WepkgControl.writeFields(paramVarArgs);
      }
      if (this.downloaderApp != null)
      {
        paramVarArgs.qD(13, this.downloaderApp.computeSize());
        this.downloaderApp.writeFields(paramVarArgs);
      }
      if (this.WebViewControl != null)
      {
        paramVarArgs.qD(14, this.WebViewControl.computeSize());
        this.WebViewControl.writeFields(paramVarArgs);
      }
      if (this.DownloadIntercept != null)
      {
        paramVarArgs.qD(15, this.DownloadIntercept.computeSize());
        this.DownloadIntercept.writeFields(paramVarArgs);
      }
      if (this.A8Key != null)
      {
        paramVarArgs.qD(16, this.A8Key.computeSize());
        this.A8Key.writeFields(paramVarArgs);
      }
      if (this.AutoRunTaskSetting != null)
      {
        paramVarArgs.qD(17, this.AutoRunTaskSetting.computeSize());
        this.AutoRunTaskSetting.writeFields(paramVarArgs);
      }
      if (this.GameCenterTabSetting != null)
      {
        paramVarArgs.qD(18, this.GameCenterTabSetting.computeSize());
        this.GameCenterTabSetting.writeFields(paramVarArgs);
      }
      if (this.GameLifeSetting != null)
      {
        paramVarArgs.qD(19, this.GameLifeSetting.computeSize());
        this.GameLifeSetting.writeFields(paramVarArgs);
      }
      if (this.GeneralJumpInfo != null)
      {
        paramVarArgs.qD(20, this.GeneralJumpInfo.computeSize());
        this.GeneralJumpInfo.writeFields(paramVarArgs);
      }
      if (this.GameCommunityInfo != null)
      {
        paramVarArgs.qD(21, this.GameCommunityInfo.computeSize());
        this.GameCommunityInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2454;
      }
    }
    label2454:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.GameIndexSetting != null) {
        paramInt = i + i.a.a.a.qC(3, this.GameIndexSetting.computeSize());
      }
      i = paramInt;
      if (this.AppStoreGoodsId != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.AppStoreGoodsId);
      }
      paramInt = i;
      if (this.GameDetailSetting != null) {
        paramInt = i + i.a.a.a.qC(6, this.GameDetailSetting.computeSize());
      }
      i = paramInt;
      if (this.AppStorePreload != null) {
        i = paramInt + i.a.a.a.qC(7, this.AppStorePreload.computeSize());
      }
      paramInt = i;
      if (this.StatusBarStyle != null) {
        paramInt = i + i.a.a.a.qC(8, this.StatusBarStyle.computeSize());
      }
      i = paramInt;
      if (this.CommJsLib != null) {
        i = paramInt + i.a.a.a.qC(11, this.CommJsLib.computeSize());
      }
      paramInt = i;
      if (this.WepkgControl != null) {
        paramInt = i + i.a.a.a.qC(12, this.WepkgControl.computeSize());
      }
      i = paramInt;
      if (this.downloaderApp != null) {
        i = paramInt + i.a.a.a.qC(13, this.downloaderApp.computeSize());
      }
      paramInt = i;
      if (this.WebViewControl != null) {
        paramInt = i + i.a.a.a.qC(14, this.WebViewControl.computeSize());
      }
      i = paramInt;
      if (this.DownloadIntercept != null) {
        i = paramInt + i.a.a.a.qC(15, this.DownloadIntercept.computeSize());
      }
      paramInt = i;
      if (this.A8Key != null) {
        paramInt = i + i.a.a.a.qC(16, this.A8Key.computeSize());
      }
      i = paramInt;
      if (this.AutoRunTaskSetting != null) {
        i = paramInt + i.a.a.a.qC(17, this.AutoRunTaskSetting.computeSize());
      }
      paramInt = i;
      if (this.GameCenterTabSetting != null) {
        paramInt = i + i.a.a.a.qC(18, this.GameCenterTabSetting.computeSize());
      }
      i = paramInt;
      if (this.GameLifeSetting != null) {
        i = paramInt + i.a.a.a.qC(19, this.GameLifeSetting.computeSize());
      }
      paramInt = i;
      if (this.GeneralJumpInfo != null) {
        paramInt = i + i.a.a.a.qC(20, this.GeneralJumpInfo.computeSize());
      }
      i = paramInt;
      if (this.GameCommunityInfo != null) {
        i = paramInt + i.a.a.a.qC(21, this.GameCommunityInfo.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localGetGameCenterGlobalSettingResponse.ShowEntrance = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ax();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ax)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameIndexSetting = ((ax)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localGetGameCenterGlobalSettingResponse.AppStoreGoodsId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ap();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ap)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameDetailSetting = ((ap)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ea();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ea)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.StatusBarStyle = ((ea)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new t();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((t)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.CommJsLib = ((t)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new et();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((et)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.WepkgControl = ((et)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aa)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.downloaderApp = ((aa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new es();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((es)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.WebViewControl = ((es)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new z();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((z)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.DownloadIntercept = ((z)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.AutoRunTaskSetting = ((m)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ak)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameCenterTabSetting = ((ak)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bd)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GameLifeSetting = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bj)localObject2).parseFrom((byte[])localObject1);
            }
            localGetGameCenterGlobalSettingResponse.GeneralJumpInfo = ((bj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localGetGameCenterGlobalSettingResponse.GameCommunityInfo = ((al)localObject2);
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