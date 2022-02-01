package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

final class s
{
  public static boolean a(String paramString, o paramo, c paramc, b paramb, k paramk, aa paramaa, ag paramag, t paramt, y paramy, ad paramad, x paramx1, a parama, x paramx2)
  {
    AppMethodBeat.i(155743);
    try
    {
      ac.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(paramString)));
      Map localMap = bv.L(paramString, "deviceinfoconfig");
      if (localMap == null)
      {
        ac.i("MicroMsg.DeviceInfoParser", "hy: null device config");
        AppMethodBeat.o(155743);
        return false;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv7") != null)
      {
        paramo.fGO = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
        paramo.fGN = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv6") != null)
      {
        paramo.fGP = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
        paramo.fGN = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.num") != null)
      {
        paramc.fEB = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.num"), 0);
        paramc.fEC = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.surface") != null)
      {
        paramc.fED = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.surface"), 0);
        paramc.fEE = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.format") != null)
      {
        paramc.fEH = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.format"), 0);
        paramc.aXS = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera") != null) {
        paramc.fEF = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
        paramc.fEG = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.enable") != null)
      {
        paramc.fEK.fFp = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.fps") != null)
      {
        paramc.fEK.fps = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.orien") != null)
      {
        paramc.fEK.fFq = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.rotate") != null)
      {
        paramc.fEK.duc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.isleft") != null)
      {
        paramc.fEK.fFr = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.width") != null)
      {
        paramc.fEK.width = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.width"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.height") != null)
      {
        paramc.fEK.height = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.height"), 0);
        paramc.fEL = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.enable") != null)
      {
        paramc.fEI.fFp = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.fps") != null)
      {
        paramc.fEI.fps = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.orien") != null)
      {
        paramc.fEI.fFq = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.rotate") != null)
      {
        paramc.fEI.duc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.isleft") != null)
      {
        paramc.fEI.fFr = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.width") != null)
      {
        paramc.fEI.width = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.width"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.height") != null)
      {
        paramc.fEI.height = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.height"), 0);
        paramc.fEJ = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null)
      {
        paramc.fEN = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
        paramc.fEM = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null)
      {
        paramc.fEO = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
        paramc.fEM = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null)
      {
        paramc.fEP = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
        paramc.fEM = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null)
      {
        paramc.fEQ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
        paramc.fEM = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.fER = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.fES = true;
        paramc.fEM = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.fEU = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.fET = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
        paramc.fEV = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
        paramc.fEW = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
        paramc.fFi = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.focusType") != null) {
        paramc.fFj = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.focusType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.fER = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.fES = true;
        paramc.fEM = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.fEU = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.fET = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
        paramc.fEX = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
        paramc.fEY = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
        paramc.fEZ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
        paramc.fFa = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
        paramc.fFb = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
        paramc.fFc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
        paramc.fFe = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
        paramc.fFf = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
        paramc.fFg = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
        paramc.fFh = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
        paramc.fFk = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
        paramc.fFl = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
        paramc.fFm = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
        paramc.fFn = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
        paramc.fFo = bs.getBoolean((String)localMap.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.streamtype") != null)
      {
        paramb.fCU = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.smode") != null)
      {
        paramb.fCV = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.smode"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.omode") != null)
      {
        paramb.fCW = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.omode"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ospeaker") != null)
      {
        paramb.fCX = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.operating") != null)
      {
        paramb.fCY = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.operating"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.moperating") != null)
      {
        paramb.fCZ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.moperating"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mstreamtype") != null)
      {
        paramb.fDa = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
        paramb.fCT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
        paramb.fDb = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.fDc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
        paramb.fDd = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
        paramb.fDe = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.volummode") != null) {
        paramb.fDf = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.volummode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
        paramb.fDs = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.micmode") != null) {
        paramb.fDr = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.micmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
        paramb.fDt = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
        paramb.fDu = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
        paramb.fDv = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
        paramb.fDw = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
        paramb.fDx = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
        paramb.fDz = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
        paramb.fDA = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
        paramb.fDB = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
        paramb.fDC = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
        paramb.fDD = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
        paramb.fDE = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti") != null) {
        paramb.fDF = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg") != null) {
        paramb.fDG = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
        paramb.fDH = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
        paramb.fDI = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
        paramb.fDJ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
        paramb.fDK = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
        paramb.fDL = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
        paramb.fDM = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio") != null) {
        paramb.fDN = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr") != null) {
        paramb.fDO = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
        paramb.fDg = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
        paramb.fDh = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
        paramb.fDi = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
        paramb.fDj = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
        paramb.fDm = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
        paramb.fDn = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
        paramb.fDo = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
        paramb.fDp = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
        paramb.fDP = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
        paramb.fDQ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null)
      {
        paramb.fDS[0] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null)
      {
        paramb.fDS[1] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null)
      {
        paramb.fDS[2] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null)
      {
        paramb.fDS[3] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null)
      {
        paramb.fDS[4] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null)
      {
        paramb.fDS[5] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null)
      {
        paramb.fDS[6] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null)
      {
        paramb.fDS[7] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null)
      {
        paramb.fDS[8] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null)
      {
        paramb.fDS[9] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null)
      {
        paramb.fDS[10] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null)
      {
        paramb.fDS[11] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null)
      {
        paramb.fDS[12] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null)
      {
        paramb.fDS[13] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0));
        paramb.fDR = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null)
      {
        paramb.fDS[14] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0));
        paramb.fDR = 1;
      }
      if ((localMap.get(".deviceinfoconfig.voip.audio.correctoff") != null) && (bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1)) {
        paramb.fDR = 0;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
        paramb.fDk = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
        paramb.fDl = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
        paramb.fDT[0] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
        paramb.fDT[1] = ((short)bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
        paramb.fEd = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
        paramb.fEe = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
        paramb.fEf = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
        paramb.fEg = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
        paramb.fDV = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
        paramb.fDq = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.fDc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag") != null) {
        paramb.fEh = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1") != null) {
        paramb.fEi = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2") != null) {
        paramb.fEj = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3") != null) {
        paramb.fEk = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4") != null) {
        paramb.fEl = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5") != null) {
        paramb.fEm = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6") != null) {
        paramb.fEn = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7") != null) {
        paramb.fEo = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8") != null) {
        paramb.fEp = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1") != null) {
        paramb.fEq = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2") != null) {
        paramb.fEr = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3") != null) {
        paramb.fEs = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4") != null) {
        paramb.fEt = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5") != null) {
        paramb.fEu = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6") != null) {
        paramb.fEv = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7") != null) {
        paramb.fEw = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8") != null) {
        paramb.fEx = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi") != null) {
        paramb.fEy = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1") != null) {
        paramb.fEz = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2") != null) {
        paramb.fEA = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakermode") != null)
      {
        paramb.fDX = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
        paramb.fDW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonemode") != null)
      {
        paramb.fDY = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
        paramb.fDW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null)
      {
        paramb.fDZ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
        paramb.fDW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.streamtype") != null)
      {
        paramb.fEa = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
        paramb.fDW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null)
      {
        paramb.fEb = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
        paramb.fDW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null)
      {
        paramb.fEc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
        paramb.fDW = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null)
      {
        paramk.fFC = true;
        paramk.fFD = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null) {
        paramk.fFu = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
        paramk.fFv = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
        paramk.fFw = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
        paramk.fFy = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
        paramk.fFx = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
        paramk.fFz = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
        paramk.fFB = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
        paramk.fFA = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.app") != null) {
        paramk.fFE = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.app"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
        paramk.fGh = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
        paramk.fGi = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
        paramk.fGj = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
        paramk.fGk = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer") != null) {
        paramk.fGl = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.vmfd") != null) {
        paramk.fFF = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vmfd"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
        paramk.fFG = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
        paramk.fFH = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
        paramk.fFI = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.linespe") != null) {
        paramk.fFJ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.linespe"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.fixspan") != null) {
        paramk.fFU = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.fixspan"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideo") != null) {
        paramk.fFK = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideo"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
        paramk.fFL = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
        paramk.fFM = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
        paramk.fFP = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
        paramk.fFO = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.fFQ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.fFR = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
        paramk.fFN = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.fFQ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.fFR = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.base") != null) {
        paramk.fGm = ((String)localMap.get(".deviceinfoconfig.voip.common.base"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
        paramk.fGn = ((String)localMap.get(".deviceinfoconfig.voip.common.packageinfo"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.classloader") != null) {
        paramk.fGo = ((String)localMap.get(".deviceinfoconfig.voip.common.classloader"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.resources") != null) {
        paramk.fGp = ((String)localMap.get(".deviceinfoconfig.voip.common.resources"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
        paramk.fFS = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
        paramk.fGq = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
        paramk.fGr = ((String)localMap.get(".deviceinfoconfig.voip.common.extpubdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
        paramk.fGs = ((String)localMap.get(".deviceinfoconfig.voip.common.extdatadir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
        paramk.fGt = ((String)localMap.get(".deviceinfoconfig.voip.common.extrootdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
        paramk.fGu = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragestate"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
        paramk.fGv = ((String)localMap.get(".deviceinfoconfig.voip.common.extcachedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
        paramk.fFT = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
        paramk.fGw = ((String)localMap.get(".deviceinfoconfig.voip.common.loadDrawable"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
        paramk.fGx = ((String)localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser"));
      }
      if ((localMap.get(".deviceinfoconfig.voip.common.sensorNearFar") != null) && (1 == bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0))) {
        com.tencent.mm.sdk.platformtools.SensorController.Gun = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
        com.tencent.mm.sdk.platformtools.SensorController.Guo = bs.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0D);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
        paramk.fGy = ((String)localMap.get(".deviceinfoconfig.voip.common.sightFullType"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
        paramk.fGz = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
        paramk.fGA = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
      }
      label7777:
      label8171:
      int i;
      label8215:
      int j;
      int k;
      if (localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null)
      {
        paramk.fGB = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
        if (paramk.fGB == 1)
        {
          bool = true;
          com.tencent.mm.compatible.g.b.cI(bool);
        }
      }
      else
      {
        if (localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
          paramk.fGC = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
          paramk.fFV = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
          paramk.fFW = bs.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0D);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
          paramk.fGD = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
          paramk.fGE = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
          paramk.fGF = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus") != null) {
          paramk.fGG = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes") != null) {
          paramk.fFX = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes") != null) {
          paramk.fFY = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes") != null) {
          paramk.fFZ = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes") != null) {
          paramk.fGa = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes") != null) {
          paramk.fGb = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.fGc = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes") != null) {
          paramk.fGd = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes") != null) {
          paramk.fGe = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes") != null) {
          paramk.fGf = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.fGg = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null)
        {
          if (bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) != 1) {
            break label9789;
          }
          bool = true;
          paramaa.fIQ = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
          paramaa.mVideoWidth = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
          paramaa.mVideoHeight = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
          paramaa.fIR = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
          paramaa.fIS = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
          paramaa.fIT = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
          paramaa.fIU = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
          paramaa.fIV = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
          paramaa.fIW = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
          paramaa.fIX = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
          paramaa.fIY = bs.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.notifythread") != null)
        {
          if (bs.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.notifythread"), 0) != 1) {
            break label9795;
          }
          bool = true;
          paramag.fJs = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null)
        {
          if (bs.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) != 1) {
            break label9801;
          }
          bool = true;
          paramag.fJt = bool;
          ac.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", new Object[] { Boolean.valueOf(paramag.fJt) });
          ai.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", paramag.fJt).commit();
        }
        paramk.dump();
        i = bs.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
        j = bs.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
        ac.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", new Object[] { Integer.valueOf(i) });
        if (paramt != null)
        {
          paramt.kT(i);
          paramt.kS(j);
        }
        k = bs.getInt((String)localMap.get(".deviceinfoconfig.soter.isSupport"), 0);
        ac.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", new Object[] { Integer.valueOf(k) });
        if (paramad != null)
        {
          if (k <= 0) {
            break label9807;
          }
          bool = true;
          label8413:
          paramad.cH(bool);
          paramad.kX(k);
        }
        if ((i == 11) && (j == 11) && (paramad != null))
        {
          paramt.kT(1);
          paramt.kS(1);
          paramad.cH(true);
          paramad.kX(1);
          paramad.Yv();
          ac.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
        }
        paramo = (String)localMap.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
        ac.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", new Object[] { paramo });
        if (paramy != null) {
          paramy.sw(paramo);
        }
        paramString = bv.L(paramString, "manufacturerName");
        ac.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", new Object[] { paramString });
        if (paramy != null) {
          paramy.i(paramString);
        }
        i = bs.getInt((String)localMap.get(".deviceinfoconfig.style.swipback"), 0);
        ac.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", new Object[] { Integer.valueOf(i) });
        if (paramy != null) {
          paramy.kU(i);
        }
        i = bs.getInt((String)localMap.get(".deviceinfoconfig.game.isLimit"), 0);
        paramString = (String)localMap.get(".deviceinfoconfig.game.limitPrompt");
        ac.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", new Object[] { Integer.valueOf(i), paramString });
        if (parama != null) {
          if (i != 1) {
            break label9813;
          }
        }
      }
      label9789:
      label9795:
      label9801:
      label9807:
      label9813:
      for (boolean bool = true;; bool = false)
      {
        parama.cE(bool);
        parama.sp(paramString);
        i = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recordertype"), -1);
        j = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
        k = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
        int m = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
        int n = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
        int i1 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
        int i2 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
        int i3 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
        int i4 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useMetering"), -1);
        int i5 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
        int i6 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
        int i7 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
        int i8 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
        int i9 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
        int i10 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
        int i11 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
        int i12 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
        int i13 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
        int i14 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
        int i15 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
        int i16 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.takePhotoAlignType"), -1);
        int i17 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.nativeToThumb"), -1);
        int i18 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.HWQPCfg"), -1);
        int i19 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useCameraApi2"), -1);
        int i20 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.camera2UseRecordStream"), -1);
        int i21 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.vendorCameraEffectSupported"), -1);
        int i22 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useImageStreamCapture"), -1);
        int i23 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useRenderScriptCropImage"), -1);
        int i24 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.isVendorDebugModeSupported"), -1);
        int i25 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CHwHevcEncodeEnable"), -1);
        int i26 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSHwHevcEncodeEnable"), -1);
        int i27 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CSwHevcEncodeEnable"), -1);
        int i28 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSSwHevcEncodeEnable"), -1);
        int i29 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CHwHevcEncodeEnable"), -1);
        int i30 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSHwHevcEncodeEnable"), -1);
        int i31 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CSwHevcEncodeEnable"), -1);
        int i32 = bs.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSSwHevcEncodeEnable"), -1);
        if (paramx1 != null)
        {
          paramx1.fHJ = i;
          paramx1.fHK = j;
          paramx1.fHL = k;
          paramx1.fHM = m;
          paramx1.fHN = n;
          paramx1.fHO = i1;
          paramx1.fHP = i2;
          paramx1.fHQ = i3;
          paramx1.fHR = i4;
          paramx1.fHS = i5;
          paramx1.fHT = i6;
          paramx1.fHW = i10;
          paramx1.fHX = i11;
          paramx1.fHY = i12;
          paramx1.fHZ = i13;
          paramx1.fIg = i14;
          paramx1.fIh = i15;
          paramx1.fIj = i16;
          paramx1.fIk = i17;
          paramx1.fIi = i18;
          paramx1.fIa = i19;
          paramx1.fIb = i20;
          paramx1.fIc = i21;
          paramx1.fId = i22;
          paramx1.fIe = i23;
          paramx1.fIf = i24;
          paramx1.fIl = i25;
          paramx1.fIm = i26;
          paramx1.fIn = i27;
          paramx1.fIo = i28;
          paramx1.fIp = i29;
          paramx1.fIq = i30;
          paramx1.fIr = i31;
          paramx1.fIs = i32;
          ac.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", new Object[] { paramx1.toString() });
        }
        if (paramx2 != null)
        {
          paramx2.fHJ = i8;
          paramx2.fHK = j;
          paramx2.fHL = k;
          paramx2.fHM = m;
          paramx2.fHN = n;
          paramx2.fHO = i1;
          paramx2.fHP = i2;
          paramx2.fHQ = i3;
          paramx2.fHR = i4;
          paramx2.fHS = i5;
          paramx2.fHT = i6;
          paramx2.fHU = i7;
          paramx2.fHV = i9;
          ac.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", new Object[] { paramx2.toString() });
        }
        AppMethodBeat.o(155743);
        return true;
        bool = false;
        break;
        bool = false;
        break label7777;
        bool = false;
        break label8171;
        bool = false;
        break label8215;
        bool = false;
        break label8413;
      }
      return false;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.DeviceInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(155743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.s
 * JD-Core Version:    0.7.0.1
 */