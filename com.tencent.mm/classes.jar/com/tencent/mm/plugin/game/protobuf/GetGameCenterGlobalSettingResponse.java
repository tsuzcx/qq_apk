package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public class GetGameCenterGlobalSettingResponse
  extends dpc
{
  public a A8Key;
  public String AppStoreGoodsId;
  public i AppStorePreload;
  public l AutoRunTaskSetting;
  public r CommJsLib;
  public x DownloadIntercept;
  public ai GameCenterTabSetting;
  public aj GameCommunityInfo;
  public an GameDetailSetting;
  public av GameIndexSetting;
  public bb GameLifeSetting;
  public bh GeneralJumpInfo;
  public boolean ShowEntrance;
  public dv StatusBarStyle;
  public em WebViewControl;
  public en WepkgControl;
  public y downloaderApp;
  
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
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.ShowEntrance);
      if (this.GameIndexSetting != null)
      {
        paramVarArgs.ni(3, this.GameIndexSetting.computeSize());
        this.GameIndexSetting.writeFields(paramVarArgs);
      }
      if (this.AppStoreGoodsId != null) {
        paramVarArgs.e(4, this.AppStoreGoodsId);
      }
      if (this.GameDetailSetting != null)
      {
        paramVarArgs.ni(6, this.GameDetailSetting.computeSize());
        this.GameDetailSetting.writeFields(paramVarArgs);
      }
      if (this.AppStorePreload != null)
      {
        paramVarArgs.ni(7, this.AppStorePreload.computeSize());
        this.AppStorePreload.writeFields(paramVarArgs);
      }
      if (this.StatusBarStyle != null)
      {
        paramVarArgs.ni(8, this.StatusBarStyle.computeSize());
        this.StatusBarStyle.writeFields(paramVarArgs);
      }
      if (this.CommJsLib != null)
      {
        paramVarArgs.ni(11, this.CommJsLib.computeSize());
        this.CommJsLib.writeFields(paramVarArgs);
      }
      if (this.WepkgControl != null)
      {
        paramVarArgs.ni(12, this.WepkgControl.computeSize());
        this.WepkgControl.writeFields(paramVarArgs);
      }
      if (this.downloaderApp != null)
      {
        paramVarArgs.ni(13, this.downloaderApp.computeSize());
        this.downloaderApp.writeFields(paramVarArgs);
      }
      if (this.WebViewControl != null)
      {
        paramVarArgs.ni(14, this.WebViewControl.computeSize());
        this.WebViewControl.writeFields(paramVarArgs);
      }
      if (this.DownloadIntercept != null)
      {
        paramVarArgs.ni(15, this.DownloadIntercept.computeSize());
        this.DownloadIntercept.writeFields(paramVarArgs);
      }
      if (this.A8Key != null)
      {
        paramVarArgs.ni(16, this.A8Key.computeSize());
        this.A8Key.writeFields(paramVarArgs);
      }
      if (this.AutoRunTaskSetting != null)
      {
        paramVarArgs.ni(17, this.AutoRunTaskSetting.computeSize());
        this.AutoRunTaskSetting.writeFields(paramVarArgs);
      }
      if (this.GameCenterTabSetting != null)
      {
        paramVarArgs.ni(18, this.GameCenterTabSetting.computeSize());
        this.GameCenterTabSetting.writeFields(paramVarArgs);
      }
      if (this.GameLifeSetting != null)
      {
        paramVarArgs.ni(19, this.GameLifeSetting.computeSize());
        this.GameLifeSetting.writeFields(paramVarArgs);
      }
      if (this.GeneralJumpInfo != null)
      {
        paramVarArgs.ni(20, this.GeneralJumpInfo.computeSize());
        this.GeneralJumpInfo.writeFields(paramVarArgs);
      }
      if (this.GameCommunityInfo != null)
      {
        paramVarArgs.ni(21, this.GameCommunityInfo.computeSize());
        this.GameCommunityInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2810;
      }
    }
    label2810:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.GameIndexSetting != null) {
        paramInt = i + g.a.a.a.nh(3, this.GameIndexSetting.computeSize());
      }
      i = paramInt;
      if (this.AppStoreGoodsId != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.AppStoreGoodsId);
      }
      paramInt = i;
      if (this.GameDetailSetting != null) {
        paramInt = i + g.a.a.a.nh(6, this.GameDetailSetting.computeSize());
      }
      i = paramInt;
      if (this.AppStorePreload != null) {
        i = paramInt + g.a.a.a.nh(7, this.AppStorePreload.computeSize());
      }
      paramInt = i;
      if (this.StatusBarStyle != null) {
        paramInt = i + g.a.a.a.nh(8, this.StatusBarStyle.computeSize());
      }
      i = paramInt;
      if (this.CommJsLib != null) {
        i = paramInt + g.a.a.a.nh(11, this.CommJsLib.computeSize());
      }
      paramInt = i;
      if (this.WepkgControl != null) {
        paramInt = i + g.a.a.a.nh(12, this.WepkgControl.computeSize());
      }
      i = paramInt;
      if (this.downloaderApp != null) {
        i = paramInt + g.a.a.a.nh(13, this.downloaderApp.computeSize());
      }
      paramInt = i;
      if (this.WebViewControl != null) {
        paramInt = i + g.a.a.a.nh(14, this.WebViewControl.computeSize());
      }
      i = paramInt;
      if (this.DownloadIntercept != null) {
        i = paramInt + g.a.a.a.nh(15, this.DownloadIntercept.computeSize());
      }
      paramInt = i;
      if (this.A8Key != null) {
        paramInt = i + g.a.a.a.nh(16, this.A8Key.computeSize());
      }
      i = paramInt;
      if (this.AutoRunTaskSetting != null) {
        i = paramInt + g.a.a.a.nh(17, this.AutoRunTaskSetting.computeSize());
      }
      paramInt = i;
      if (this.GameCenterTabSetting != null) {
        paramInt = i + g.a.a.a.nh(18, this.GameCenterTabSetting.computeSize());
      }
      i = paramInt;
      if (this.GameLifeSetting != null) {
        i = paramInt + g.a.a.a.nh(19, this.GameLifeSetting.computeSize());
      }
      paramInt = i;
      if (this.GeneralJumpInfo != null) {
        paramInt = i + g.a.a.a.nh(20, this.GeneralJumpInfo.computeSize());
      }
      i = paramInt;
      if (this.GameCommunityInfo != null) {
        i = paramInt + g.a.a.a.nh(21, this.GameCommunityInfo.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(149416);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localGetGameCenterGlobalSettingResponse.ShowEntrance = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new av();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.GameIndexSetting = ((av)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localGetGameCenterGlobalSettingResponse.AppStoreGoodsId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new an();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((an)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.GameDetailSetting = ((an)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.AppStorePreload = ((i)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.StatusBarStyle = ((dv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.CommJsLib = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new en();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((en)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.WepkgControl = ((en)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new y();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.downloaderApp = ((y)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new em();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((em)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.WebViewControl = ((em)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new x();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((x)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.DownloadIntercept = ((x)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.A8Key = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.AutoRunTaskSetting = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ai();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.GameCenterTabSetting = ((ai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.GameLifeSetting = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetGameCenterGlobalSettingResponse.GeneralJumpInfo = ((bh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localGetGameCenterGlobalSettingResponse.GameCommunityInfo = ((aj)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse
 * JD-Core Version:    0.7.0.1
 */