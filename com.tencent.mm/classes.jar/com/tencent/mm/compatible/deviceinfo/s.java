package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class s
{
  public static boolean a(String paramString, o paramo, c paramc, b paramb, k paramk, aa paramaa, ag paramag, t paramt, y paramy, ad paramad, x paramx1, a parama, x paramx2)
  {
    AppMethodBeat.i(155743);
    try
    {
      Log.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(paramString)));
      Map localMap = XmlParser.parseXml(paramString, "deviceinfoconfig", null);
      if (localMap == null)
      {
        Log.i("MicroMsg.DeviceInfoParser", "hy: null device config");
        AppMethodBeat.o(155743);
        return false;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv7") != null)
      {
        paramo.gHU = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
        paramo.gHT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.cpu.armv6") != null)
      {
        paramo.gHV = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
        paramo.gHT = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.num") != null)
      {
        paramc.gFx = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.num"), 0);
        paramc.gFy = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.surface") != null)
      {
        paramc.gFz = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.surface"), 0);
        paramc.gFA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.format") != null)
      {
        paramc.gFD = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.format"), 0);
        paramc.bik = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera") != null) {
        paramc.gFB = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autofloatcamera"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
        paramc.gFC = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.enable") != null)
      {
        paramc.gFG.gGn = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.fps") != null)
      {
        paramc.gFG.fps = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.orien") != null)
      {
        paramc.gFG.gGo = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.rotate") != null)
      {
        paramc.gFG.dYT = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.isleft") != null)
      {
        paramc.gFG.gGp = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.width") != null)
      {
        paramc.gFG.width = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.width"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.back.height") != null)
      {
        paramc.gFG.height = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.back.height"), 0);
        paramc.gFH = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.enable") != null)
      {
        paramc.gFE.gGn = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.fps") != null)
      {
        paramc.gFE.fps = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.orien") != null)
      {
        paramc.gFE.gGo = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.rotate") != null)
      {
        paramc.gFE.dYT = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.isleft") != null)
      {
        paramc.gFE.gGp = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.width") != null)
      {
        paramc.gFE.width = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.width"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.front.height") != null)
      {
        paramc.gFE.height = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.front.height"), 0);
        paramc.gFF = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null)
      {
        paramc.gFJ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
        paramc.gFI = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null)
      {
        paramc.gFK = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
        paramc.gFI = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null)
      {
        paramc.gFL = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
        paramc.gFI = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null)
      {
        paramc.gFM = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
        paramc.gFI = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.gFN = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.gFO = true;
        paramc.gFI = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.gFQ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.gFP = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
        paramc.gFR = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
        paramc.gFS = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
        paramc.gGf = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.focusType") != null) {
        paramc.gGg = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.focusType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.num") != null)
      {
        paramc.gFN = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
        paramc.gFO = true;
        paramc.gFI = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
        paramc.gFQ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
        paramc.gFP = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
        paramc.gFT = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
        paramc.gFU = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
        paramc.gFV = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
        paramc.gFW = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
        paramc.gFX = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
        paramc.gFY = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
        paramc.gGa = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
        paramc.gGb = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
        paramc.gGc = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
        paramc.gGd = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
        paramc.gGh = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
        paramc.gGi = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.enable720cap") != null) {
        paramc.gGe = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.enable720cap"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.stFilter") != null) {
        paramc.gGj = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.stFilter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
        paramc.gGk = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
        paramc.gGl = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
        paramc.gGm = Util.getBoolean((String)localMap.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.streamtype") != null)
      {
        paramb.gDB = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.smode") != null)
      {
        paramb.gDC = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.smode"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.omode") != null)
      {
        paramb.gDD = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.omode"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ospeaker") != null)
      {
        paramb.gDE = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.operating") != null)
      {
        paramb.gDF = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.operating"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.moperating") != null)
      {
        paramb.gDG = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.moperating"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mstreamtype") != null)
      {
        paramb.gDH = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
        paramb.gDA = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
        paramb.gDI = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.gDJ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
        paramb.gDK = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
        paramb.gDL = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.volummode") != null) {
        paramb.gDM = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.volummode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
        paramb.gEd = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.micmode") != null) {
        paramb.gEc = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.micmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
        paramb.gEe = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
        paramb.gEf = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
        paramb.gEg = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
        paramb.gEh = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
        paramb.gEi = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
        paramb.gEk = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
        paramb.gEl = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
        paramb.gEm = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
        paramb.gEn = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
        paramb.gEo = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
        paramb.gEp = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti") != null) {
        paramb.gEq = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.nsModeNewMulti"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg") != null) {
        paramb.gEr = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.voipfullbandcfg"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
        paramb.gEs = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
        paramb.gEt = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
        paramb.gEu = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
        paramb.gEv = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
        paramb.gEw = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
        paramb.gEx = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio") != null) {
        paramb.gEy = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcCompRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr") != null) {
        paramb.gEz = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcDnGainThr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcMode") != null) {
        paramb.gEA = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcMode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain") != null) {
        paramb.gEB = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain") != null) {
        paramb.gEC = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain") != null) {
        paramb.gED = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcCRatio") != null) {
        paramb.gEF = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcCRatio"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR") != null) {
        paramb.gEG = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcTarget") != null) {
        paramb.gEE = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcTarget"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcBase") != null) {
        paramb.gEH = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcBase"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR") != null) {
        paramb.gEI = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR") != null) {
        paramb.gEJ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.waveAgcDamper") != null) {
        paramb.gEK = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.waveAgcDamper"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
        paramb.gDN = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
        paramb.gDO = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
        paramb.gDP = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
        paramb.gDQ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
        paramb.gDX = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
        paramb.gDY = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
        paramb.gDZ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
        paramb.gEa = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
        paramb.gEL = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
        paramb.gEM = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null)
      {
        paramb.gEO[0] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null)
      {
        paramb.gEO[1] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null)
      {
        paramb.gEO[2] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null)
      {
        paramb.gEO[3] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null)
      {
        paramb.gEO[4] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null)
      {
        paramb.gEO[5] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null)
      {
        paramb.gEO[6] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null)
      {
        paramb.gEO[7] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null)
      {
        paramb.gEO[8] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null)
      {
        paramb.gEO[9] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null)
      {
        paramb.gEO[10] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null)
      {
        paramb.gEO[11] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null)
      {
        paramb.gEO[12] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null)
      {
        paramb.gEO[13] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0));
        paramb.gEN = 1;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null)
      {
        paramb.gEO[14] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0));
        paramb.gEN = 1;
      }
      if ((localMap.get(".deviceinfoconfig.voip.audio.correctoff") != null) && (Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1)) {
        paramb.gEN = 0;
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
        paramb.gDR = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
        paramb.gDS = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
        paramb.gEP[0] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
        paramb.gEP[1] = ((short)Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0));
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
        paramb.gEZ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
        paramb.gFa = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
        paramb.gFb = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
        paramb.gFc = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
        paramb.gER = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
        paramb.gEb = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
        paramb.gDJ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag") != null) {
        paramb.gFd = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dFlag"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1") != null) {
        paramb.gFe = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2") != null) {
        paramb.gFf = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3") != null) {
        paramb.gFg = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4") != null) {
        paramb.gFh = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5") != null) {
        paramb.gFi = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6") != null) {
        paramb.gFj = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7") != null) {
        paramb.gFk = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8") != null) {
        paramb.gFl = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dAzim8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1") != null) {
        paramb.gFm = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2") != null) {
        paramb.gFn = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3") != null) {
        paramb.gFo = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl3"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4") != null) {
        paramb.gFp = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl4"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5") != null) {
        paramb.gFq = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl5"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6") != null) {
        paramb.gFr = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl6"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7") != null) {
        paramb.gFs = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl7"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8") != null) {
        paramb.gFt = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dElvl8"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.forbiddenUseSco") != null) {
        paramb.gDT = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.forbidSco"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.audioForbiddenStrategy") != null) {
        paramb.gDU = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.audioForbiddenStrategy"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.audioForbiddenRefreshTime") != null) {
        paramb.gDV = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.audioForbiddenRefreshTime"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.audioForbiddenRequestTimes") != null) {
        paramb.gDW = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.audioForbiddenRequestTimes"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi") != null) {
        paramb.gFu = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dPhi"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1") != null) {
        paramb.gFv = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta1"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2") != null) {
        paramb.gFw = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.audio.mt3dTheta2"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakermode") != null)
      {
        paramb.gET = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
        paramb.gES = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonemode") != null)
      {
        paramb.gEU = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
        paramb.gES = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null)
      {
        paramb.gEV = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
        paramb.gES = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.streamtype") != null)
      {
        paramb.gEW = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
        paramb.gES = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null)
      {
        paramb.gEX = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
        paramb.gES = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null)
      {
        paramb.gEY = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
        paramb.gES = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null)
      {
        paramk.gGA = true;
        paramk.gGB = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.js") != null) {
        paramk.gGs = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.js"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
        paramk.gGt = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
        paramk.gGu = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
        paramk.gGw = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
        paramk.gGv = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
        paramk.gGx = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
        paramk.gGz = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
        paramk.gGy = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.app") != null) {
        paramk.gGC = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.app"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
        paramk.gHg = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
        paramk.gHh = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
        paramk.gHi = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
        paramk.gHj = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer") != null) {
        paramk.gHk = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipnewrenderer"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipUseRemovePreviewCallback") != null) {
        paramk.gHn = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipUseRemovePreviewCallback"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipUseCameraApi2") != null) {
        paramk.gHo = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipUseCameraApi2"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipUseNewCameraModular") != null) {
        paramk.gHp = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipUseNewCameraModular"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv") != null) {
        paramk.gHq = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.voipgpucrop") != null) {
        paramk.gHr = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.voipgpucrop"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.groupRs") != null) {
        paramk.gHf = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.groupRs"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.vmfd") != null) {
        paramk.gGD = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vmfd"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
        paramk.gGE = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
        paramk.gGF = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
        paramk.gGG = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.linespe") != null) {
        paramk.gGH = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.linespe"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.fixspan") != null) {
        paramk.gGS = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.fixspan"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideo") != null) {
        paramk.gGI = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideo"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
        paramk.gGJ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
        paramk.gGK = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
        paramk.gGN = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
        paramk.gGM = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.gGO = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.gGP = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
        paramk.gGL = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.audioformat") != null) {
        paramk.gGO = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.audioformat"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.qrcam") != null) {
        paramk.gGP = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.qrcam"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.base") != null) {
        paramk.gHs = ((String)localMap.get(".deviceinfoconfig.voip.common.base"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
        paramk.gHt = ((String)localMap.get(".deviceinfoconfig.voip.common.packageinfo"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.classloader") != null) {
        paramk.gHu = ((String)localMap.get(".deviceinfoconfig.voip.common.classloader"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.resources") != null) {
        paramk.gHv = ((String)localMap.get(".deviceinfoconfig.voip.common.resources"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
        paramk.gGQ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
        paramk.gHw = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
        paramk.gHx = ((String)localMap.get(".deviceinfoconfig.voip.common.extpubdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
        paramk.gHy = ((String)localMap.get(".deviceinfoconfig.voip.common.extdatadir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
        paramk.gHz = ((String)localMap.get(".deviceinfoconfig.voip.common.extrootdir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
        paramk.gHA = ((String)localMap.get(".deviceinfoconfig.voip.common.extstoragestate"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
        paramk.gHB = ((String)localMap.get(".deviceinfoconfig.voip.common.extcachedir"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
        paramk.gGR = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
        paramk.gHC = ((String)localMap.get(".deviceinfoconfig.voip.common.loadDrawable"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
        paramk.gHD = ((String)localMap.get(".deviceinfoconfig.voip.common.loadXmlResourceParser"));
      }
      if ((localMap.get(".deviceinfoconfig.voip.common.sensorNearFar") != null) && (1 == Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0))) {
        com.tencent.mm.sdk.platformtools.SensorController.sensorNearFar = true;
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
        com.tencent.mm.sdk.platformtools.SensorController.configNearFarDivideRatio = Util.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0D);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
        paramk.gHE = ((String)localMap.get(".deviceinfoconfig.voip.common.sightFullType"));
      }
      if (localMap.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
        paramk.gHF = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
      }
      if (localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
        paramk.gHG = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
      }
      label8566:
      int i;
      label8960:
      label9004:
      int j;
      int k;
      if (localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null)
      {
        paramk.gHH = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
        if (paramk.gHH == 1)
        {
          bool = true;
          com.tencent.mm.compatible.h.b.du(bool);
        }
      }
      else
      {
        if (localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
          paramk.gHI = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
          paramk.gGT = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
          paramk.gGU = Util.getDouble((String)localMap.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0D);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
          paramk.gHJ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
          paramk.gHK = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
          paramk.gHL = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus") != null) {
          paramk.gHM = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus"), 1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes") != null) {
          paramk.gGV = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes") != null) {
          paramk.gGW = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes") != null) {
          paramk.gGX = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes") != null) {
          paramk.gGY = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes") != null) {
          paramk.gGZ = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.gHa = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes") != null) {
          paramk.gHb = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes") != null) {
          paramk.gHc = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw264MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes") != null) {
          paramk.gHd = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.hw265MaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
          paramk.gHe = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.common.vcodec1MixMaxDecRes"), -1);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null)
        {
          if (Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) != 1) {
            break label10675;
          }
          bool = true;
          paramaa.gKa = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
          paramaa.mVideoWidth = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
          paramaa.mVideoHeight = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
          paramaa.gKb = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
          paramaa.gKc = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
          paramaa.gKd = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
          paramaa.gKe = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
          paramaa.gKf = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
          paramaa.gKg = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
          paramaa.gKh = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
          paramaa.gKi = Util.getInt((String)localMap.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.notifythread") != null)
        {
          if (Util.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.notifythread"), 0) != 1) {
            break label10681;
          }
          bool = true;
          paramag.gKI = bool;
        }
        if (localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null)
        {
          if (Util.getInt((String)localMap.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) != 1) {
            break label10687;
          }
          bool = true;
          paramag.gKJ = bool;
          Log.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", new Object[] { Boolean.valueOf(paramag.gKJ) });
          MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", paramag.gKJ).commit();
        }
        paramk.dump();
        i = Util.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
        j = Util.getInt((String)localMap.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
        Log.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", new Object[] { Integer.valueOf(i) });
        if (paramt != null)
        {
          paramt.ox(i);
          paramt.ow(j);
        }
        k = Util.getInt((String)localMap.get(".deviceinfoconfig.soter.isSupport"), 0);
        Log.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", new Object[] { Integer.valueOf(k) });
        if (paramad != null)
        {
          if (k <= 0) {
            break label10693;
          }
          bool = true;
          label9202:
          paramad.dt(bool);
          paramad.oB(k);
        }
        if ((i == 11) && (j == 11) && (paramad != null))
        {
          paramt.ox(1);
          paramt.ow(1);
          paramad.dt(true);
          paramad.oB(1);
          paramad.apf();
          Log.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
        }
        paramo = (String)localMap.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
        Log.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", new Object[] { paramo });
        if (paramy != null) {
          paramy.DY(paramo);
        }
        paramString = XmlParser.parseXml(paramString, "manufacturerName", null);
        Log.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", new Object[] { paramString });
        if (paramy != null) {
          paramy.r(paramString);
        }
        i = Util.getInt((String)localMap.get(".deviceinfoconfig.style.swipback"), 0);
        Log.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", new Object[] { Integer.valueOf(i) });
        if (paramy != null) {
          paramy.oy(i);
        }
        i = Util.getInt((String)localMap.get(".deviceinfoconfig.game.isLimit"), 0);
        paramString = (String)localMap.get(".deviceinfoconfig.game.limitPrompt");
        Log.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", new Object[] { Integer.valueOf(i), paramString });
        if (parama != null) {
          if (i != 1) {
            break label10699;
          }
        }
      }
      label10675:
      label10681:
      label10687:
      label10693:
      label10699:
      for (boolean bool = true;; bool = false)
      {
        parama.dq(bool);
        parama.DR(paramString);
        if (localMap.get(".deviceinfoconfig.debug.screenCast") != null) {
          paramk.gHl = Util.getInt((String)localMap.get(".deviceinfoconfig.debug.screenCast"), 0);
        }
        if (localMap.get(".deviceinfoconfig.debug.blackBoardProjectDebug") != null) {
          paramk.gHm = Util.getInt((String)localMap.get(".deviceinfoconfig.debug.blackBoardProjectDebug"), 0);
        }
        i = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recordertype"), -1);
        j = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
        k = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
        int m = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
        int n = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
        int i1 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
        int i2 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
        int i3 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
        int i4 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useMetering"), -1);
        int i5 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
        int i6 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
        int i7 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
        int i8 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
        int i9 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
        int i10 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
        int i11 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
        int i12 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
        int i13 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
        int i14 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
        int i15 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
        int i16 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.takePhotoAlignType"), -1);
        int i17 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.nativeToThumb"), -1);
        int i18 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.HWQPCfg"), -1);
        int i19 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useCameraApi2"), -1);
        int i20 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.fullFuncApi2"), -1);
        int i21 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.camera2UseRecordStream"), -1);
        int i22 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.vendorCameraEffectSupported"), -1);
        int i23 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useImageStreamCapture"), -1);
        int i24 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.useRenderScriptCropImage"), -1);
        int i25 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.isVendorDebugModeSupported"), -1);
        int i26 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CHwHevcEncodeEnable"), -1);
        int i27 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSHwHevcEncodeEnable"), -1);
        int i28 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureC2CSwHevcEncodeEnable"), -1);
        int i29 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.captureSNSSwHevcEncodeEnable"), -1);
        int i30 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CHwHevcEncodeEnable"), -1);
        int i31 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSHwHevcEncodeEnable"), -1);
        int i32 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxC2CSwHevcEncodeEnable"), -1);
        int i33 = Util.getInt((String)localMap.get(".deviceinfoconfig.mmsight.remuxSNSSwHevcEncodeEnable"), -1);
        if (paramx1 != null)
        {
          paramx1.gIP = i;
          paramx1.gIQ = j;
          paramx1.gIR = k;
          paramx1.gIS = m;
          paramx1.gIT = n;
          paramx1.gIU = i1;
          paramx1.gIV = i2;
          paramx1.gIW = i3;
          paramx1.gIX = i4;
          paramx1.gIY = i5;
          paramx1.gIZ = i6;
          paramx1.gJc = i10;
          paramx1.gJd = i11;
          paramx1.gJe = i12;
          paramx1.gJf = i13;
          paramx1.gJn = i14;
          paramx1.gJo = i15;
          paramx1.gJq = i16;
          paramx1.gJr = i17;
          paramx1.gJp = i18;
          paramx1.gJg = i19;
          paramx1.gJi = i20;
          paramx1.gJh = i21;
          paramx1.gJj = i22;
          paramx1.gJk = i23;
          paramx1.gJl = i24;
          paramx1.gJm = i25;
          paramx1.gJs = i26;
          paramx1.gJt = i27;
          paramx1.gJu = i28;
          paramx1.gJv = i29;
          paramx1.gJw = i30;
          paramx1.gJx = i31;
          paramx1.gJy = i32;
          paramx1.gJz = i33;
          Log.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", new Object[] { paramx1.toString() });
        }
        if (paramx2 != null)
        {
          paramx2.gIP = i8;
          paramx2.gIQ = j;
          paramx2.gIR = k;
          paramx2.gIS = m;
          paramx2.gIT = n;
          paramx2.gIU = i1;
          paramx2.gIV = i2;
          paramx2.gIW = i3;
          paramx2.gIX = i4;
          paramx2.gIY = i5;
          paramx2.gIZ = i6;
          paramx2.gJa = i7;
          paramx2.gJb = i9;
          Log.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", new Object[] { paramx2.toString() });
        }
        AppMethodBeat.o(155743);
        return true;
        bool = false;
        break;
        bool = false;
        break label8566;
        bool = false;
        break label8960;
        bool = false;
        break label9004;
        bool = false;
        break label9202;
      }
      return false;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.DeviceInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(155743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.s
 * JD-Core Version:    0.7.0.1
 */